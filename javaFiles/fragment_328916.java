import scala.collection.JavaConverters;

public static Result index() {
    List<String> scripts = Arrays.asList(
        "script1.js",
        ...
        "scriptN.js"
    );
    scala.collection.immutable.List<String> ls = JavaConverters.asScalaBufferConverter(scripts).asScala().toList();
    return ok(views.html.index.render(ls));
}