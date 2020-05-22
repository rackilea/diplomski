public static void main(String args[]) {

    String fileName = args[0];
    Scanner s = null;
    String subsequence = "TAG";
    String dna = "";
    int count = 0;

    try {
        s = new Scanner(new File(fileName));
        while(s.hasNext()) {
            dna += s.next().trim();
        }
        count = countSubstring(subsequence, dna); // any of the above methods
        System.out.println(subsequence + " appears " + count + " times");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
        // s.close(); Don't put s.close() here, use finally
    } finally {
        if(s != null) {
            s.close();
        }
    }
}