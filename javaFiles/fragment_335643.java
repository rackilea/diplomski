void testEncapsulation() {
    Inner inner = new Inner(3);
    Outer outer = new Outer(inner);
    inner = inner.withInnerValue(4); <---- this is forced to change
    assertEquals(3, outer.getInner().getInnerValue());
}