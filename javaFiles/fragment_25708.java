JSONArray jsonArray = new JSONArray();
    for (Dependency dependency: dependencyList) {
        String version = "0.0";
        if (dependency.getVersion() != null &&
                dependency.getVersion().startsWith("${")) {
            version = (String) properties.get(dependency.getVersion()
                    .substring(2, dependency.getVersion().length() - 1));
        } else {
            version = dependency.getVersion();
        }
        if (version != null) {
            String a1[] = version.split("\\.");
            int i = a1.length;
            if (i >= 2) {
                version = a1[0] + "." + a1[1];
            }
        }
        JSONObject obj=new JSONObject();
        obj.put("name",dependency.getArtifactId());
        obj.put("Version",version);
        jsonArray.put(obj);
    }

    writer.write(jsonArray.toJSONString());