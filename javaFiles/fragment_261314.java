/* You can use the below code to print the output using system.out.println() */


StringBuilder stringBuilder = new StringBuilder();
        try {
            String contents = "" ;
            Process p = Runtime.getRuntime().exec("cat /data/data/com.admarvel.testerofflineappv242/shared_prefs/myPrefs.xml");
            InputStream inputStream =  p.getInputStream();`enter code here`
            BufferedReader in = new BufferedReader(
                    new InputStreamReader( inputStream ) );
                while ( ( contents = in.readLine() ) != null )
                {
                    stringBuilder.append(contents);
                }
                in.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("text" + stringBuilder);