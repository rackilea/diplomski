RDFNode node; // subject, predicate, or object    

if (node.isURIResource()) {
    return "<" + node.asResource().getURI() + ">";
} else {
    ...
}