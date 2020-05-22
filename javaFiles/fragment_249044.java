BufferedReader in = null;
try {  
    String[] cmd1 = {"C:\WINDOWS\system32\cmd.exe","/c","start","java"," -cp D:\java\hi\src"," helo"};
    Process p = Runtime.getRuntime().exec(cmd1);  
    in = new BufferedReader(new InputStreamReader(p.getInputStream()));  
    String line = null;  
    while ((line = in.readLine()) != null) {  
        System.out.println(line);  
    }
 } catch (IOException e) {  
        e.printStackTrace();  
 } finally {
    in.close();
 }