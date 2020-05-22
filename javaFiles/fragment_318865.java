class LocatorFixer {
  private Locator copied;

  XMLFilterImpl wrap(XMLReader delegate) {
    return new XMLFilterImpl(delegate) {
      @Override
      public void setDocumentLocator(Locator real) {
        if (copied != null) {
          super.setDocumentLocator(copied);
        } else {
          copied = new LocatorImpl(real);
          super.setDocumentLocator(real);
        }
      }
    };
  }

  ContentHandler wrap(ContentHandler delegate) {
    XMLFilterImpl fixed = wrap((XMLReader) null);
    fixed.setContentHandler(delegate);
    return fixed;
  }
}