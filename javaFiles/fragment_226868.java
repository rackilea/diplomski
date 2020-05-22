public class ASTtry {
static class Visitor implements NodeVisitor {
    List<String> ls;

    Visitor(List<String> loc) {
        ls = loc;
    }

    @Override
    public boolean visit(AstNode node) {
        if (node instanceof Name) {
            ls.add(node.getString());
        }
        if (node instanceof Loop) {
            int type = node.getType();
            ls.add(Token.typeToName(type));
        }
        return true;
    }
}

public static void main(String[] args) throws IOException {
    ASTtry ast = new ASTtry();
    CompilerEnvirons env = new CompilerEnvirons();
    setEnvironmentVariables(env);
    File scriptFile = new File("whatever path my file was");
    FileReader fr = new FileReader(scriptFile);
    AstNode root = new Parser(env).parse(fr, null, 1);
    List<String> allTokens = new ArrayList<>();
    root.visit(new Visitor(allTokens));
    Properties properties = new Properties();
    InputStream propFile;
    propFile = new FileInputStream("I had imports seperated by commas in this file");
    properties.load(propFile);
    ast.check(properties, allTokens);
}

private static void setEnvironmentVariables(CompilerEnvirons env) {
    env.setRecordingLocalJsDocComments(true);
    env.setAllowSharpComments(true);
    env.setRecordingComments(true);
    env.setIdeMode(true);
    env.setErrorReporter(new ErrReporter());
    env.setRecoverFromErrors(true);
    env.setGenerateObserverCount(true);
}

public boolean check(Properties properties, List<String> loc) {
    once I had all the lines of code, imports, i can easily loop around them for all the validations I need.
}