Process process = Runtime.getRuntime().exec("logcat -<flags>");
BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

String line;
while ((line = bufferedReader.readLine()) != null) {
    //code here
}