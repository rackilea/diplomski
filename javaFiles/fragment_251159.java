public PdfDictionary getParentObject() {
    return getPdfObject().getAsDictionary(PdfName.Parent);
}

public PdfAnnotation getParent() {
    if (parent == null) {
        parent = makeAnnotation(getParentObject());
    }
    return parent;
}