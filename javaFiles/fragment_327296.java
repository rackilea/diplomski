boolean met[] = new boolean[256]; // Replace 256 with the size of alphabet you are using
List<Character> res = new ArrayList<Character>();
for(Character c:data){
  int int_val = (int)c.charValue();
  if (!met[int_val]) {
     met[int_val] = true;
     res.add(c);
  }
}

// res holds the answer.