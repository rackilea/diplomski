Pair<? super Object, ? super Object> intPair = new Pair<Object, Object>(4, 9);
Object val2 = intPair.getSecond();
System.out.printf("val2: %s, isInt: %s%n", val2, (val2 instanceof Integer));
intPair.setSecond(10);
val2 = intPair.getSecond();
System.out.printf("val2: %s, isInt: %s%n", val2, (val2 instanceof Integer));