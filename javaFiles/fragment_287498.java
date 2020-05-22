if (connection.getRequestMethod().equalsIgnoreCase("POST")) {
        connection.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded");
        connection.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(
                connection.getOutputStream());
        wr.writeBytes("");
        wr.flush();
        wr.close();
    } else {
        connection.connect();
    }