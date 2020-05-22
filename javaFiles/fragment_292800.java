import static j2html.TagCreator.*;
import j2html.tags.Text;

public class Test {

    private static Text $(String str) {
        return new Text(str);
    }

    public static void main(String[] args) {
        System.out.println(p($("The fox ran over the "), b("the bridge"), $(" in the forest")));
    }

}