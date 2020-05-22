Collection<IfcProduct> products = model.getCollection(IfcProduct.class);
for(IfcProduct product: products){
    List<IfcRepresentation> representations = product.getRepresentation().getRepresentations();
    assert ! representations.isEmpty();
    assert representations.get(0) instanceof IfcShapeRepresentation:
    Collection<IfcRepresentationItem> repr = representations.get(0).getItems();
    assert !repr.isEmpty();
    IfcRepresentationItem representationItem = repr.iterator().next();
    assert representationItem instanceof IfcFacetedBrep;
    for(IfcFace face: ((IfcFacetedBrep)representationItem).getOuter().getCfsFaces()){
        for(IfcFaceBound faceBound: face.getBounds()){
            IfcLoop loop = faceBound.getBound();
            assert loop instanceof IfcPolyLoop;
            for(IfcCartesianPoint point: ((IfcPolyLoop) loop).getPolygon()){
                point.getCoordinates();
            }
        }
    }
}