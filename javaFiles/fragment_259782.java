private void generateTable(final MyCSS hcCss) {

        Table table = new Table(null,             
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

        System.out.println(table.toHtmlString());
}