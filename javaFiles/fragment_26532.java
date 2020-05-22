BufferedReader br = null;
try {
    br = ...;
    // do your stuff
}
catch (Exception e) {
    // handle exception
}
finally {
    if(br != null)
        br.close();
}