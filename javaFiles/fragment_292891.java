System.setProperty("http.proxyHost", "YOUR PROXY");

          URL url = new URL("YOUR WebSite");

            URLConnection con = url.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);

            in.close();

    }