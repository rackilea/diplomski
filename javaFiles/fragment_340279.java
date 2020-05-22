ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
rows = generateRows(); //method not shown, but returns a ArrayList<ArrayList<String>>
Set<ArrayList<String>> set = new LinkedHashSet<ArrayList<String>>();
set.addAll(rows);
rows.clear();
rows.addAll(set);