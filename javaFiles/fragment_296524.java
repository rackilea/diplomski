URL u = new URL(Url);
        URLConnection uc = u.openConnection();
        HttpURLConnection  conn = (HttpURLConnection) uc;

        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("SOAPAction", getHeaderUrl() + "/" + method);
        conn.setRequestProperty("Content-type", "text/xml");

        OutputStream out = conn.getOutputStream();
        Writer wr = new OutputStreamWriter(out);

        wr.write(msg);
        wr.flush();
        wr.close();

        InputStream in = conn.getInputStream();
        String rsp="";
        int c;
        while ((c = in.read()) != -1) { 
            System.out.write(c);
            rsp = rsp.concat(String.valueOf((char)c));
        }
        in.close();
        rsp = deSOAP(rsp);
        response = response.fromXML(rsp);
        return response;