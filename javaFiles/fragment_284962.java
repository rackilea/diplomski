Integer a1 = new Integer("12");
Integer b1 = new Integer("12");
//a1 == b1 returns false because they point to two different Integer objects

Integer aa = Integer.valueOf("12");
Integer bb = Integer.valueOf("12");
//aa == bb returns true because they point to same cached object