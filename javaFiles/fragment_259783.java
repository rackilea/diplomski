public class TableComponentMethods {

    public static void embedTable1In(Body body) {

        new Table(body,             
            new CustomAttribute("cellspacing", "0"),
            new CustomAttribute("cellpadding", "3")) {{
            new TBody(this) {{
                new Tr(this) {{
                    new Td(this,
                        new Style("padding: 3px")) {{
                        new NoTag(this, "XXXX");
                    }};
                }};
            }};
        }};

    }

    public static void embedTable2In(Body body) {

        new Table(body,             
            new CustomAttribute("cellspacing", "0"),
            new CustomAttribute("cellpadding", "3")) {{
            new TBody(this) {{
                new Tr(this) {{
                    new Td(this,
                        new Style("padding: 3px")) {{
                        new NoTag(this, "Table 2");
                    }};
                }};
            }};
        }};

    }

}

public class WffWebTest extends Html {

    private Body body;

    public WffWebTest() {
        super(null);
        setPrependDocType(true);
        develop();
    }

    private void develop() {
        body = new Body(this);
    }

    public Body getBody() {
        return body;
    }

    public static void main(String[] args) {
        WffWebTest finalHtml = new WffWebTest();

        // this will add table as a child in Body tag
        TableComponentMethods.embedTable1In(finalHtml.getBody());
        TableComponentMethods.embedTable2In(finalHtml.getBody());

        System.out.println(finalHtml.toHtmlString());

    }
}