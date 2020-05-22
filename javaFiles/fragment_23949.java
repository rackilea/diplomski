InternalContent content = ...; // you don't know the actual type 
Copier copier = new Copier();
Copy copy = content.accept(new InternalContentVisitor<Copy>() {
    @Override
    public Copy visitText(InternalTextContent c) {
        return copier.copyText(c.getText());
    }

    @Override
    public Copy visitImage(InternalImageContent c) {
        return copier.copyImage(c.getImage());
    }
});