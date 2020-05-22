ProcessBuilder pb = new ProcessBuilder("svd");
Process p = pb.start();
//You could also read the error stream, so that when svd is not correctly set on the running system, you may alert the user.
BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
StringBuilder sb = new StringBuilder();
String line;
while ((line = br.readLine()) != null) {
    sb.append(line);
}

int retCode = p.waitFor();
if(retCode == 2){
    //alert the user that svd is not correctly set on PATH variable.
    LOGGER.error(sb);
    System.out.println("ERROR!! Could not run svd  because it's not correctly set on PATH variable");
}