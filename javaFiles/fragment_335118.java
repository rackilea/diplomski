public class Main {
    public static void main(String args[]) {
        System.setOut(new java.io.PrintStream(System.out) {

            private StackTraceElement getCallSite() {
                for (StackTraceElement e : Thread.currentThread()
                        .getStackTrace())
                    if (!e.getMethodName().equals("getStackTrace")
                            && !e.getClassName().equals(getClass().getName()))
                        return e;
                return null;
            }

            @Override
            public void println(String s) {
                println((Object) s);
            }

            @Override
            public void println(Object o) {
                StackTraceElement e = getCallSite();
                String callSite = e == null ? "??" :
                    String.format("%s.%s(%s:%d)",
                                  e.getClassName(),
                                  e.getMethodName(),
                                  e.getFileName(),
                                  e.getLineNumber());
                super.println(o + "\t\tat " + callSite);
            }
        });

        System.out.println("Hello world");
        printStuff();
    }

    public static void printStuff() {
        System.out.println("More output!");
    }
}