public static void main(String[] args) {
    if(args.length < 1) {
        System.err.println("need jar file");
        return;
    }

    String pathname = args[0];
    try {
        ZipFile file = new ZipFile(new File(pathname));
        Enumeration<? extends ZipEntry> e = file.entries();
        while(e.hasMoreElements()) {
            ZipEntry entry = e.nextElement();
            System.out.println(entry.getName());
        }
    } catch(Exception ex) {
        ex.printStackTrace();
    }
}