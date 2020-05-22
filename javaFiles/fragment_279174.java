try {   
    Process p = Runtime.getRuntime().exec("java -jar library.jar parameters");
p.waitFor();
} catch (InterruptedException | IOException e) {
    e.printStackTrace();
}