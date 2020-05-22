Set<Integer> set = new HashSet<>();
for (int i=0; i < a.length; ++i) {
    set.add(a[i]);
}

int numDuplicates = a.length - set.size();