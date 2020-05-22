ByteBuffer bb = ...
Set<Character> destinations = new LinkedHashSet<Character>(
        Arrays.asList('A',  'B',  'C',  'D',  'E'));
bb.put((byte) destinations.size());
for (char b : destinations) bb.put((byte) b);

bb.flip();

int size = bb.get();
Set<Character> destinations2 = new LinkedHashSet<Character>();
for (int i = 0; i < size; i++)
    destinations2.add((char) bb.get());
System.out.println(destinations2);