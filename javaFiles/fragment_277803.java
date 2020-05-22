String text = "abcdefghijklmnopqrstuvwxyz";
Random random = new Random();

int i = 5;  // define the length of the substring

int index = random.nextInt(text.length() - i);  // get a random starting index


System.out.println(text.substring(index, index + i)); // print the substring