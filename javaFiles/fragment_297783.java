public static void main(String[] args) {    
    String[] cmd = { "/bin/sh", "-c", "java -jar ~/apktool1.5.2/apktool.jar d /home/talha/Desktop/myapk.apk /home/talha/Desktop/myapk" };
    BufferedReader bri = null, bre = null;
    int exitC = 0;
    try {
        Process p = Runtime.getRuntime().exec(cmd);
        exitC = p.waitFor();
        bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
        bre = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        String line = "";
        while ((line = bri.readLine()) != null) {
            System.out.println(line);               
        }
        while ((line = bre.readLine()) != null) {
            System.out.println(line);
        }
        bri.close();
        bre.close();
    } catch (Exception e) {
        e.printStackTrace();
    } 
    System.out.println("Exit Code: "+ exitC);
}