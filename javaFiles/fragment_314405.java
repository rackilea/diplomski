import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.TextNode;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
public static void main(String[] args) {
    Document document = Jsoup.parse("This text is not highlighted <hlTag>but this is</hlTag> this isn't again <hlTag>and this is</hlTag>");

    List<String> highlighted = document.select("hlTag")
            .stream()
            .map(element -> element.html())
            .collect(Collectors.toList());

    List<String> nonHighlighted = document.body().childNodes().stream()
            .filter(node -> node instanceof TextNode)
            .map(node -> node.toString().replaceAll("\n",""))
            .collect(Collectors.toList());

    highlighted.forEach(System.out::println);
    nonHighlighted.forEach(System.out::println);
}
}