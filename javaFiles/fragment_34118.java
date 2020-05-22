HashCode<Integer> i = new HashCode<>().codeAsInt(2);
HashCode<Character> c = new HashCode<>().codeAsInt('C');
HashCode<String> s = new HashCode<>().codeAsInt("name");

i.codeAsInt(2);
c.codeAsInt('C');
s.codeAsInt("name");