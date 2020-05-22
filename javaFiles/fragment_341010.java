private final WriterFactory writerFactory;

public ClassUnderTest(@Inject WriterFactory writerFactory){
   this.writerFactory = writerFactory;
}

@Override
public void initIndexFile(File emptyIndexFile) {
    try {
        Writer writer = writerFactory.create(emptyIndexFile);
        writer.write("[]");
        writer.close();
    } catch (IOException e) {
        throw new IndexFileInitializationException(
            "Error initialization index file " + emptyIndexFile.getPath()
        );
    }
}