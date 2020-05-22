final String regex = "(?<=\\w)[ -]+(?=\\w)";

System.out.println(Arrays.toString(" test".split(regex)));
System.out.println(Arrays.toString("-test".split(regex)));
System.out.println(Arrays.toString("test test".split(regex)));
System.out.println(Arrays.toString(" test test".split(regex)));
System.out.println(Arrays.toString("test-".split(regex)));
System.out.println(Arrays.toString("test-test".split(regex)));
System.out.println(Arrays.toString("a-test".split(regex)));