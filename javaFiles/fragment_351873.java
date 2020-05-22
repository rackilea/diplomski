List<Character> l = new ArrayList<Character>(Lalpha.length); 

for (char c : Lalpha)
    l.add(c);

Collections.shuffle(l);

Map<Character, Character> encoding = new HashMap<Character, Character>(Lalpha.length);
Map<Character, Character> decoding = new HashMap<Character, Character>(Lalpha.length);

for (int i = 0 ; i < Lalpha.length ; i++) {
    encoding.put(Lalpha[i], l.get(i));
    decoding.put(l.get(i), Lalpha[i]);
}