Gson gson = new Gson();
        try {
            JsonResponse jsonResponse = gson.fromJson(new FileReader(new File("resources/jsonexample.json")), JsonResponse.class);
            System.out.println(jsonResponse.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }