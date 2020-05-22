Document doc = Jsoup.connect(site).get();
    doc.body().traverse(new NodeVisitor() {

        @Override
        public void head(Node node, int depth) {
            if (node instanceof TextNode) {
                TextNode tn = ((TextNode) node);
                // Try to improve this filter for the nodes who contain
                // texts with a whitespaces
                if (tn.text().replaceAll("\\s*", "").length() > 0) {
                    System.out.println("Tag:" + tn.parent().nodeName()
                            + ", text:" + tn.text());
                }
            }
        }

        @Override
        public void tail(Node node, int depth) {
            // Do Nothing
        }
    });