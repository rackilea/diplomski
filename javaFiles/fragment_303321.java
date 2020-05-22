public class ContentReader {
    public static void main(String[] args) throws IOException { 
        Configuration conf = NutchConfiguration.create();       
        Options opts = new Options();       
        GenericOptionsParser parser = new GenericOptionsParser(conf, opts, args);       
        String[] remainingArgs = parser.getRemainingArgs();     
        FileSystem fs = FileSystem.get(conf);
        String segment = remainingArgs[0];
        Path file = new Path(segment, Content.DIR_NAME + "/part-00000/data");
        SequenceFile.Reader reader = new SequenceFile.Reader(fs, file, conf);
        Text key = new Text();
        Content content = new Content();
        // Loop through sequence files
        while (reader.next(key, content)) {
            try {
                System.out.write(content.getContent(), 0,
                        content.getContent().length);
            } catch (Exception e) {
            }
        }
    }
}