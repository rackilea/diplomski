Process p=r.exec("cmd.exe /c compile.bat",         //path to executable
            null,                                  // env vars, null means pass parent env
            new File("C:\\blahblah"));

    InputStream is=p.getInputStream();
    BufferedReader br= new BufferedReader(new InputStreamReader(is));

    String line=new String();
    while ((line=br.readLine())!=null) System.out.println (line);