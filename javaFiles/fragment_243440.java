int c = -153;
System.out.printf("%32s%n",Integer.toBinaryString(c >>= 2));
System.out.printf("%32s%n",Integer.toBinaryString(c <<= 2));
System.out.printf("%32s%n",Integer.toBinaryString(c >>>= 2));
System.out.println(Integer.toBinaryString(c <<= 2));

c = 153;
System.out.printf("%32s%n",Integer.toBinaryString(c >>= 2));
System.out.printf("%32s%n",Integer.toBinaryString(c <<= 2));
System.out.printf("%32s%n",Integer.toBinaryString(c >>>= 2));
System.out.printf("%32s%n",Integer.toBinaryString(c <<= 2));