Process uptimeProc = Runtime.getRuntime().exec("powershell -Command \"get-eventlog System | where-object {$_.EventID -eq '6005'} | sort -desc TimeGenerated\"");
    uptimeProc.waitFor();
    BufferedReader br = new BufferedReader(new InputStreamReader(uptimeProc.getInputStream()));
    String line = null;
    while((line = br.readLine())!=null){
        System.out.println(line);
    }