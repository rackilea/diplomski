public static void main(String[] args) {
        String name = "com.gargoylesoftware.htmlunit";
        for (int i = 0; i < 5; i++) {
            System.out.println(Logger.getLogger(name).getLevel());
            Logger.getLogger(name).setLevel(Level.OFF);
            System.runFinalization();
            System.gc();
            System.runFinalization();
            Thread.yield();
        }
    }