@Root(name = "chapter")
public class Chapter
{
    @Attribute
    private String num;
    @ElementList(name = "verse", required = false, inline = true) /* <-- ! */
    private List<Verse> verse;

    // ...
}