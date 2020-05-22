// Element.getTransformTo: get transform to ancestor or root (null)
public AffineTransform getTransformTo(Element ancestor) {
    AffineTransform t = getCompositeTransform();
    Element parent = getParent();
    while (parent != null && parent != ancestor) {
        t.preConcatenate(parent.getCompositeTransform());
        parent = parent.getParent();
    }
}

// Element.translateInAncestorSpace
// ancestor may be null for root/global space
public void translateInAncestorSpace(Element ancestor, Point translation) {
    AffineTransform fromAncestor = getTransformTo(ancestor); // to ancestor space
    fromAncestor.invert(); // from ancestor space

    // [NEW] re-apply element rotation since translation occurs after rotation
    fromAncestor.rotate(Math.toRadians(angle), anchor.x, anchor.y);

    translation = fromAncestor.deltaTransform(translation, new Point());

    // translation is now in element space; add to existing translation
    element.setX(element.getX() + translation.x);
    element.setY(element.getY() + translation.y);
}

// example usage:
// (this should move the element 10px to the right, regardless
// of parent transforms)
element.translateInAncestorSpace(null, new Point(10, 0));