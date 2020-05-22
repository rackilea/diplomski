public static void main(String[] args) {

    String result = "eggs toast bacon bacon butter ice beer".toUpperCase();

    PrintStream p = null;

    try {
        p = new PrintStream(new FileOutputStream("myfile.txt"));

        for (String s : result.split("\\s")) {
            p.println(s);
            p.flush(); // probably not necessary
        }

    } catch (Exception e) {
        e.printStackTrace(); // should really use a logger instead!
    } finally {
        try {
            p.close(); // wouldn't need this in Java 7!
        } catch (Exception e) {
        }
    }
}