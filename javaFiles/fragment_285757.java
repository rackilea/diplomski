String str = "sentence with multiple words and spaces";

String[] split = str.split(" ");  // split string at every space

Random rand = new Random();
int index = rand.nextInt(split.length); // choose a random space to split at

// Concatenate words before and after the random space
String first = String.join(" ", Arrays.copyOfRange(split, 0, index));                 
String second = String.join(" ", Arrays.copyOfRange(split, index, split.length)); 

System.out.println(first);
System.out.println(second);