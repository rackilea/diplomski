public class StusMagicLargeFileReader  {
    private static final long PAGE_SIZE = Integer.MAX_VALUE;
    private List<MappedByteBuffer> buffers = new ArrayList<MappedByteBuffer>();
    private final byte raw[] = new byte[1];

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/stu/test.txt");
        FileChannel fc = (new FileInputStream(file)).getChannel(); 
        StusMagicLargeFileReader buffer = new StusMagicLargeFileReader(fc);
        long position = file.length() / 2;
        String candidate = buffer.getString(position--);
        while (position >=0 && !candidate.equals('\n')) 
            candidate = buffer.getString(position--);
        //have newline position or start of file...do other stuff    
    }
    StusMagicLargeFileReader(FileChannel channel) throws IOException {
        long start = 0, length = 0;
        for (long index = 0; start + length < channel.size(); index++) {
            if ((channel.size() / PAGE_SIZE) == index)
                length = (channel.size() - index *  PAGE_SIZE) ;
            else
                length = PAGE_SIZE;
            start = index * PAGE_SIZE;
            buffers.add(index, channel.map(READ_ONLY, start, length));
        }    
    }
    public String getString(long bytePosition) {
        int page  = (int) (bytePosition / PAGE_SIZE);
        int index = (int) (bytePosition % PAGE_SIZE);
        raw[0] = buffers.get(page).get(index);
        return new String(raw);
    }
}