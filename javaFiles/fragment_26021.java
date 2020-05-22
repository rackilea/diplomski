Pairs pairs = new Pairs();
pairs.addPair("Padded", 1);
pairs.addPair("Leather", 2);
pairs.addPair("Hide", 4);
pairs.getPair("Hide").setValue(3);
System.out.println(pairs.getPair("Hide").getValue());
System.out.println(pairs.getRandomPair());