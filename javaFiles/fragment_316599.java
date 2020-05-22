@Select("div.g")
public class GoogleResult  {

    @Text(select = "h3.r")
    public String title;

    @Text(select = "div.s cite")
    public String link;

    @Text(select = "span.st")
    public String body;

}