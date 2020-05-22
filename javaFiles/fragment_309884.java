public String login(String name ,String password) {
StringBuilder sURL = new StringBuilder(100);
        StringBuilder sb1 = new StringBuilder();
        System.out.println("FF:"+pathReader);
        try {
            sURL.append("http://10.0.3.2/MYCODE/app/login.php?");
            sURL.append("name="+name);
            sURL.append("&password="+password);
            InputStream is = new URL(sURL.toString()).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            int cp;
            while ((cp = rd.read()) != -1) {
                sb1.append((char) cp);
            }

            }
        catch (Exception me) {
            System.out.println("## Exception :" + me.getMessage());
        }
        sb1.toString();
        }