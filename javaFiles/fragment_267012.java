HttpURLConnection conn = (HttpURLConnection) new URL(sourceURL).openConnection();
        String userpass = jiraUserName + ":" + jiraPassword;
        String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
        conn.setRequestProperty ("Authorization", basicAuth);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }
        String fileName = sourceURL.substring(sourceURL.lastIndexOf('/') + 1, sourceURL.length());
        Path targetPath = new File(targetDirectory + File.separator + fileName).toPath();
        Files.copy(conn.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);