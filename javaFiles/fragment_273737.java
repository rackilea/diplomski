OutputStream wr = new DataOutputStream(conn.getOutputStream());


    BufferedReader br = new BufferedReader(new FileReader(new File("request.xml")));

    //reading file and writing to URL
    System.out.println("Request:-");
    String st;
    while ((st = br.readLine()) != null) {
        System.out.print(st);
        wr.write(st.getBytes());
    }

    //Flush&close the writing to URL.
    wr.flush();
    wr.close();

    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    String output;

    StringBuffer response = new StringBuffer();
    while ((output = in.readLine()) != null) {
        response.append(output);
    }

    in.close();


    // printing result from response
    System.out.println("Response:-" + response.toString());