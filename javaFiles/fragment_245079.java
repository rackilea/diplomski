BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        String line;

        List<String> exIps = new ArrayList<>();
        Map<String, List<String>> stingrayIps = new HashMap<>();
        boolean startedExt = false;
        while ((line = reader.readLine()) != null) {


            if (!line.startsWith("#") && !line.isEmpty() && !line.trim().equals("") && !line.trim().equals("\n")) {
                if (line.equalsIgnoreCase("$ipaddress_range = [")) {
                    startedExt = true;
                } else if (line.equalsIgnoreCase("];")) {
                    startedExt = false;
                }

                if (startedExt && !line.equalsIgnoreCase("$ipaddress_range = [")) {
                    exIps.add(line.replaceAll(",$", "").replaceAll("\"", "").trim());
                }
            }
        }
        if (exIps.size() > 0) {
            stingrayIps.put("stingrayIps", exIps);
        }