Test c1;
Test c2;

c1 = new Test("Z", "B", 4);
c2 = new Test("Y", "D", 7);
hash.put("A", c1);
hash.put("C", c2);

Test getC1 = (Test)hash.get("A");
Test getC2 = (Test)hash.get("C");