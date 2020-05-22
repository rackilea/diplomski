public static void main (String[] args) {
        final String[] INPUT = new String[] {
"<TEST>",
"    <NODE1>",
"         <VALUE>         Test</VALUE>",                // 2 tabs 1 space here
"    </NODE1>",
"    <NODE1>",
"        <VALUE>         Test</VALUE>",
"    </NODE1>",
"</TEST>"
    };

        for (String str: INPUT) {
            System.out.println("NEW: " + htmlspecialchars(str));
        }
    }

    private static String htmlspecialchars(String str) {
        return str
            .replaceAll("&", "&quot;")                  // replace html entities
            .replaceAll("<", "&lt;")
            .replaceAll(">", "&gt;")
            .replaceAll("(?<=^\\s*)\t", "    ")         // replace tabs by 4 spaces
            .replaceAll("(?<=^\\s*)    ", "&#09;")      // replace 4 spaces by &#09;
            .replaceAll("(?<=^(?:&#09;)*) ", "&nbsp;"); // replace rest spaces by &nbsp;
    }