Object[] original = { new Object(), null };
Object[] copy = new Object[2];
System.arraycopy(original, 0, copy, 0, original.length);
Object[] copy2 = Arrays.copyOf(original, original.length + 1);
copy2[1] = 2;
System.out.println(original[1]); // null
System.out.println(copy2[1]); // 2