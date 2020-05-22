public static void main(String[] args) throws Exception {
            // Create a pattern to match comments
            Pattern p = 
                Pattern.compile("\\\\.sp(\\d+)", Pattern.MULTILINE);

            // Get a Channel for the source file
            File f = new File("Replacement.java");
            FileInputStream fis = new FileInputStream(f);
            FileChannel fc = fis.getChannel();

            // Get a CharBuffer from the source file
            ByteBuffer bb = 
                fc.map(FileChannel.MAP_RO, 0, (int)fc.size());
            Charset cs = Charset.forName("8859_1");
            CharsetDecoder cd = cs.newDecoder();
            CharBuffer cb = cd.decode(bb);

            // Run some matches
            Matcher m = p.matcher(cb);
     int i = 0;
    int n=0;
            while (m.find())
                n= Integer.parseInt(m.group(1));  //first group,0, is the whole string , 1 is the subgroup
     for(i=0;i<n;i++)
                System.out.println("\n");   
     }