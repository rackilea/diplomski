public class Extract {
    public static void main(String[] args) {
        String text =
            "abcabcabcabc<2007-01-12><name1>" +
            "<2007-01-12>abcabcabcxxx<name2>" +
            "<2007-01-11>abcabcabcyyy<name3>" +
            "<2007-02-12>abcabcabczzz<name4>" +
            "abcabcabc123<2007-03-12><name5>" +
            "<date>abcabcabc456<name6>";
        System.out.println(
            text.replaceAll(
                "(text)<(text)>(text)<(text)>"
                    .replace("text", "[^<]*"),
                "$1$3 - $2 - $4\n"
            )
        );
    }
}