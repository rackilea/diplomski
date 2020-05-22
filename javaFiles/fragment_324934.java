public static void main(String... args) throws IOException {
    for (char ch = 0; ch < Character.MAX_VALUE; ch++) {
        if (Character.isJavaIdentifierStart(ch) && !Character.isLetter(ch))
            System.out.println("interface " + ch + " { }");
    }
}

interface $ { }
interface _ { }
interface ¢ { }
interface £ { }
interface ¤ { }
interface ¥ { }
interface € { }