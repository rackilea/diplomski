@Api(name = "myApi", version = "v1")
public class MyApi {

    public static class PseudoCon {
        public String foo;
    }

    public static class SourceContainer {
        public String source;
    }

    @ApiMethod(name = "pseudo", path = "pseudo", httpMethod = HttpMethod.POST)
    public PseudoCon getPseudoCode(SourceContainer sourceContainer){
        String source = sourceContainer.source;
        PseudoCon result = new PseudoCon();
        result.foo = source.substring(0, 1);
        return result;
    }
}