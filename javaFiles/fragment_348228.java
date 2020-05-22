/**
 * The image names for which dynamic images will be generated
 */
private static final String[] IMAGE_NAMES = new String[] {"one", "two", "three"};

public ImageResourcesPanel(final String wicketId, IModel<Book> book) {
    super(wicketId, book);

     int refNumber = book.getModelObject().getRefNumber();


    ListView<String> listView = new ListView<String>("list", Arrays.asList(IMAGE_NAMES)) {

        @Override
        protected void populateItem(ListItem<String> item) {

            String imageName = item.getModelObject();
            imageParameters.set("name", imageName);
            imageParameters.set("ref_number", refNumber);

    final ResourceReference imagesResourceReference = new ImageResourceReference();
    final PageParameters imageParameters = new PageParameters();

            // generates nice looking url (the mounted one) to the current image
            CharSequence urlForWordAsImage = getRequestCycle().urlFor(imagesResourceReference, imageParameters);
            ExternalLink link = new ExternalLink("link", urlForWordAsImage.toString());
            link.setBody(Model.of(imageName));
            item.add(link);

        }
    };
    add(listView);
}