Set<Integer> s; //contains your Integers
...
Set<Integer> temp = new Set<Integer>();
for(Integer i : s)
    temp.add(i+1);
s.clear();
s.addAll(temp);