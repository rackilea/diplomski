// Read json file
        String jsonFileStr = new String(
                Files.readAllBytes(Paths
                        .get("PATH TO YOUR EMPLOYEE JSON")),
                StandardCharsets.UTF_8);
        System.out.println(jsonFileStr);
        JSONArray jsonArray = (JSONArray) new JSONParser().parse(jsonFileStr);

        // Create employee data to be add to json file
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("firstName", "Justin");
        employeeDetails.put("lastName", "Saklitinov");

        JSONObject employeeObject = new JSONObject();
        employeeObject.put("employee", employeeDetails);

        JSONObject employeeDetails2 = new JSONObject();
        employeeDetails2.put("firstName", "Zara");
        employeeDetails2.put("lastName", "Lovez");

        JSONObject employeeObject2 = new JSONObject();
        employeeObject2.put("employee", employeeDetails2);

        // Add data to jsonArray read from json file
        jsonArray.put(employeeObject);
        jsonArray.put(employeeObject2);

        // Writing the jsonArray back to file
        String strPath = "PATH TO EMPLOYEE JSON";
        File strFile = new File(strPath);
        boolean fileCreated = strFile.createNewFile();
        Writer objWriter = new BufferedWriter(new FileWriter(strFile));
        objWriter.write(jsonArray.toString());
        objWriter.flush();
        objWriter.close();