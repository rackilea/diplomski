File file = new File("out.pdf");
        if (!file.exists()) {
            File source = request.getServletContext()
                    .getRealPath("/WEB-INF/resources/in.pdf");
            Files.copy(source.toPath(), file.toPath());
        }