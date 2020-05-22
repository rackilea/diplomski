URL url = new URL(PageURL);

        HttpURLConnection c = (HttpURLConnection) url.openConnection();
        c.setConnectTimeout(8000);
        c.setReadTimeout(15000);
        BufferedReader inn = new BufferedReader(new InputStreamReader(
                c.getInputStream()));
        Log.d("TAG", "-----> Got response on Thread" + String.valueOf(j));
        StringBuffer sb = new StringBuffer("");
        String l = null;
        while ((l = inn.readLine()) != null) {
            sb.append(l);
        }
        inn.close();


        Document xmlDocument = builder.parse(sb.toString());

        XPath xPath =  XPathFactory.newInstance().newXPath();