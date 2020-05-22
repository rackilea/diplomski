List<Rectangle> originalRects = ...;

/* record index of each rectangle object.
 * Using a hash map makes lookups efficient,
 * and using an IdentityHashMap means we lookup by object identity
 * not value.
 */
IdentityHashMap<Rectangle, Integer> originalIndices = new IdentityHashMap<Rectangle, Integer>();
for(int i=0; i<originalRects.size(); i++) {
    originalIndices.put(originalRects.get(i), i);
}

/* copy rectangle list */
List<Rectangle> sortedRects = new ArrayList<Rectangle>();
sortedRects.addAll(originalRects);

/* and sort */
Collections.sort(sortedRects, new LeftToRightComparator());

/* Loop through original list */
for(int i=0; i<sortedRects.size(); i++) {
    Rectangle rect = sortedRects.get(i);
    /* Lookup original index efficiently */
    int origIndex = originalIndices.get(rect);

    /* I know the original, and sorted indices plus the rectangle itself */
...