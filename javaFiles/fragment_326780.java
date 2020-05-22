Map<Character, Integer> counts = new HashMap<Character, Integer>();

BufferedReader in = new BufferedReader(new FileReader("data.txt"));
int c;
while((c = in.read()) != -1) {
    int count = counts.containsKey((char) c) ? counts.get((char) c) : 0;
    counts.put((char) c, count + 1);
}