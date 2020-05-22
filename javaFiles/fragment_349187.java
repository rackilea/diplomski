public static void main(String[] args) {
    try {
        String command = "zip -P password -r encrypted.zip folderIWantToZip";
        Process p = Runtime.getRuntime().exec(command);
        InputStream is = p.getInputStream();
        int waitFor = p.waitFor();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));


        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("line:" + line);
        }
        is = p.getErrorStream();
        reader = new BufferedReader(new InputStreamReader(is));
        while ((line = reader.readLine()) != null) {
            System.out.println("ErrorStream:line: " + line);
        }
        System.out.println("waitFor:" + waitFor);
        System.out.println("exitValue:" + p.exitValue());
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}