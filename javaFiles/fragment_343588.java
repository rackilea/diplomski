// declaration
ArrayList<Integer> LRU_frame = new ArrayList<Integer>();

...

if (LRU_frame.contains(a)) {
    LRU_frame.remove((Integer) a);
    LRU_frame.add(0, a);
}