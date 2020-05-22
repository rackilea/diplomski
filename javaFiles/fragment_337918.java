ArrayList<Integer> list = new ArrayList<Integer>();
...
int size = list.size();
for (Integer i : list) { 
    ...
    if (--size == 0) {
        // Last item.
        ...
    }
}