ArrayList<ArrayList<Integer>> j = new ArrayList<ArrayList<Integer>>();
ArrayList<Integer> w = new ArrayList<Integer>();
w.add(1); w.add(2);
j.add(w);
ArrayList<Integer> t = new ArrayList<Integer>();
t.add(1); t.add(2);
return j.contains(t); // should return true.