public static void main(String args[]) {
    try {
        Runtime.getRuntime().exec(new String[] {"bash", "-c", "ls -lrt > ttrr"});
    } catch(Exception e) {
        e.printStackTrace();
    }
}