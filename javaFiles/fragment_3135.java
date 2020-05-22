Map<String, ArrayList<Integer>> hm = new HashMap<String, ArrayList<Integer>>();
int currentLineNumber = 0;
for (String line = file.readLine(); line != null; line = file.readLine()) {

    if(!hm.containsKey(line))
    {
        hm.put(line, new ArrayList<Integer>());
    }

    hm.get(line).add(currentLineNumber);

    currentLineNumber++;
}