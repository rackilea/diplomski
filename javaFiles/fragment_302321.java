public static void ripD2sLvl(File source) throws IOException {
// rip character level from .d2s diablo II save
    InputStream is = null;
    try {
        is = new FileInputStream(source);
        byte[] buffer = new byte[1];
        is.skip(43);
        if ((is.read(new byte[1])) > 0) {
            System.out.println("=====reading from "+source.getName()+"======");
            //System.out.write(buffer);
            System.out.println(Arrays.toString(buffer));
        }
    } finally {
        is.close();
    }
}