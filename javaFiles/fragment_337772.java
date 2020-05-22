private static void loadLibrary() {
    try {
        InputStream in = null;
        File fileOut = null;
        String osName = System.getProperty("os.name");
        Utils.out.println(Main.class, osName);
        if(osName.startsWith("Windows")){
            int bitness = Integer.parseInt(System.getProperty("sun.arch.data.model"));
            if(bitness == 32){
                Utils.out.println(Main.class, "32 bit detected");
                in = Main.class.getResourceAsStream("/opencv/x86/opencv_java245.dll");
                fileOut = File.createTempFile("lib", ".dll");
            }
            else if (bitness == 64){
                Utils.out.println(Main.class, "64 bit detected");
                in = Main.class.getResourceAsStream("/opencv/x64/opencv_java245.dll");
                fileOut = File.createTempFile("lib", ".dll");
            }
            else{
                Utils.out.println(Main.class, "Unknown bit detected - trying with 32 bit");
                in = Main.class.getResourceAsStream("/opencv/x86/opencv_java245.dll");
                fileOut = File.createTempFile("lib", ".dll");
            }
        }
        else if(osName.equals("Mac OS X")){
            in = Main.class.getResourceAsStream("/opencv/mac/libopencv_java245.dylib");
            fileOut = File.createTempFile("lib", ".dylib");
        }


        OutputStream out = FileUtils.openOutputStream(fileOut);
        IOUtils.copy(in, out);
        in.close();
        out.close();
        System.load(fileOut.toString());
    } catch (Exception e) {
        throw new RuntimeException("Failed to load opencv native library", e);
    }