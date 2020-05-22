get(API_CONTEXT + "/result/download", (request, response) -> {

        String key = request.queryParams("filepath");
        Path path = Paths.get("/tmp/"+key);
        byte[] data = null;
        try {
            data = Files.readAllBytes(path);
        } catch (Exception e1) {

            e1.printStackTrace();
        }

        HttpServletResponse raw = response.raw();
        response.header("Content-Disposition", "attachment; filename=image.jpg");
        response.type("application/force-download");
        try {
            raw.getOutputStream().write(data);
            raw.getOutputStream().flush();
            raw.getOutputStream().close();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return raw;


   });