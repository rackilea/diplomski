public void testCtor() {
 Inventory i = new Inventory();
 assertNotNull(i.items);
 assertEqual(1, i.items.length);
 assertEqual(0, i.currentIndex);
}