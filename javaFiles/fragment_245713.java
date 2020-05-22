Gson gson = new Gson();
             Type type = new TypeToken<List<Bundle>>() {}.getType();
             String json = gson.toJson(bundleList, type);
             System.out.println(json);
             List<Bundle> fromJson = gson.fromJson(json, type);

             for (Bundle bundle : fromJson) {
                     System.out.println(bundle);
             }