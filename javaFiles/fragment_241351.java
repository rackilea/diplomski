class DynamicJavaSourceCodeObject extends SimpleJavaFileObject{
private String sourceCode ;

/**
 * Converts the name to an URI, as that is the format expected by JavaFileObject
 *
 *
 * @param String name given to the class file
 * @param String source the source code string
 */
protected DynamicJavaSourceCodeObject(String name, String source) {
    super(URI.create("string:///" +name.replaceAll("\\.", "/") + Kind.SOURCE.extension), Kind.SOURCE);
    this.sourceCode = source ;
}

@Override
public CharSequence getCharContent(boolean ignoreEncodingErrors)
        throws IOException {
    return sourceCode ;
}

public String getSourceCode() {
    return sourceCode;
}
}