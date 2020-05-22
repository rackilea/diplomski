public static void main(String[] args) {
        String jsonString = "{  \"configuration\": {\"dryRunTest\": {\"id\": null,\"defaultName\": \"sample.xml\",      \"ParamsMap\": null,      \"defaultVersion\": \"1.2\",      \"dryRunTestOn\": true    },    \"port\": 2323,    \"ip\": \"11.11.11.111\",    \"configFile\": \"config.json\",    \"Name\": \"007\",    \"URL\": \"http://11.111.111.51/ma/api/ag/\",    \"Password\": \"123\",    \"configDirectory\": \"sss\",    \"platform\": \"Windows7\",    \"Repository\": {      \"repositoryURL\": \"http://11.11.111.11/\"    }  }}";


        Gson gson = new Gson();
        ParentConfiguration parentConfiguration = gson.fromJson(jsonString, ParentConfiguration.class);
        System.out.println(parentConfiguration.toString());
    }