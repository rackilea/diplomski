public class FooPanel extends Panel {

    private static final long   serialVersionUID    = 1L;

    public static class LinkBean{
        private String link;
        private String label;
        public LinkBean(final String link, final String label) {
            this.link = link;
            this.label = label;
        }
        public String getLabel() {
            return this.label;
        }
        public String getLink() {
            return this.link;
        }
        public void setLabel(final String label) {
            this.label = label;
        }
        public void setLink(final String link) {
            this.link = link;
        }


    }

    public FooPanel(final String id) {
        super(id);
        this.add(new ListView<LinkBean>("item", 
                Arrays.asList(
                    new LinkBean("http://www.google.com/","Google"), 
                    new LinkBean("http://www.ebay.com/", "Ebay"))
                ) {

            private static final long   serialVersionUID    = 1L;

            @Override
            protected void populateItem(final ListItem<LinkBean> item) {
                item.add(new ExternalLink("link", item.getModelObject().getLink())
                    .add(new Label("label",item.getModelObject().getLabel()))
                );

            }
        });
    }
}