JSONParser parser = new JSONParser();
        FileReader fr = new FileReader("path to json file");
        JSONObject data = (JSONObject) parser.parse(fr);
        JSONArray kernelParams = (JSONArray) data.get("KernelParameters");
for(int i=0; i<kernelParams.size();i++) {
            JSONObject jsonObject = (JSONObject) kernelParams.get(i);
            kparams.add(jsonObject);
        }
JSONObject jo = (JSONObject) kparams.get(0);
        System.out.println("to get Sigma for e.g.: " + jo.get("sigma"));