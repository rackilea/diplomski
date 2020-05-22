url = new URL(SERVER_URL);
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);

        OutputStreamWriter out = new OutputStreamWriter(
                                  connection.getOutputStream());

        String post_string;
        post_string = "deviceID="+tm.getDeviceId().toString();

        // send post string to server
        out.write(post_string);
        out.close();

        //grab a return string from server
        BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                    connection.getInputStream()));

        Toast.makeText(context, in.readLine(), Toast.LENGTH_SHORT).show();