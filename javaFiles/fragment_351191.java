import java.util.UUID;

public class CodeGenerator {

    private static CodeGenerator singleInstance = new CodeGenerator();

    private String video;
    private String codePlayList;

    private CodeGenerator() {
        video = UUID.randomUUID().toString();
        codePlayList = UUID.randomUUID().toString();
    }

    public static CodeGenerator getInstance() {
        return singleInstance;
    }

    public String getCodeVideo() {
        return video;
    }

    public String getCodePlayList() {
        return codePlayList;
    }
}