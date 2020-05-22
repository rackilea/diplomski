Process uptimeProc = Runtime.getRuntime().exec("cmd /c systeminfo | find \"System Boot Time:\"");
    uptimeProc.waitFor();
    BufferedReader br = new BufferedReader(new InputStreamReader(uptimeProc.getInputStream()));
    String line = null;
    line = br.readLine();
    System.out.println("Boot Time : " + line);