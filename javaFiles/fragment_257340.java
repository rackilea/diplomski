public static void write(String key, String value){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try{
            BufferedReader br = new BufferedReader(new FileReader(launcherConfigFile));
            GeneralJsonConfig gjcObject = gson.fromJson(br, GeneralJsonConfig.class);
    if(key.equals("testKey")){
        gjc.setaucString(value);
    }
            String json = gson.toJson(gjcObject);
            FileWriter fw = new FileWriter(launcherConfigFile);
            fw.write(json);
            fw.close();
            br.close();
        } catch (IOException e){
            main.er.LogError("23", "");
        }