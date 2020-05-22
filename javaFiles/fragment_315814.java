BufferedReader bf = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));

String output = null;

        while ((output = bf.readLine()) != null) {
         System.out.println("bf.readLine() value is--- - " + output );

            JSONObject obj = new JSONObject(output);
            System.out.println("output is " + output);
            resCode = obj.getString("resCode");
            resDesc = obj.getString("COUNT");
        }