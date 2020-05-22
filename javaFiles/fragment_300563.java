public void testWorldMapIntInt() {
    try {
        WorldMap w = new WorldMap(-1, -1);
        Assert.fail("should have thrown IndexOutOfBoundsException");
    }
    catch (IndexOutOfBoundsException e) {}
}