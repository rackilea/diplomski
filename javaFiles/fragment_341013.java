private final Writer writer;

public ClassUnderTest(@Inject Writer writer){
   this.writer = writer;
}

@Override
public void initIndexFile() {
    try {
        writer.write("[]");
        writer.close();
    } catch (IOException e) {
        throw new IndexFileInitializationException(
            "Error initialization index file " + emptyIndexFile.getPath()
        );
    }
}