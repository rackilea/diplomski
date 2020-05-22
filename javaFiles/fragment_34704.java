@Root(name = "Command", strict = false)
public class AppCommand {

    @Element(name = "Variable", required = false)
    @Getter
    private Variable variable;

    @Element(name = "Content", required = false)
    @Getter
    private String content;
}