List<Integer> ints = new ArrayList<Integer>();
// For each element in jobs array
for (int i = 0; i < jobs.length; i++)
    // For each csv in current element
    for (String s : jobs[i].split(","))
        ints.add(Integer.parseInt(s)); // parse and add to ints

for (int i : ints)
    System.out.println(i);