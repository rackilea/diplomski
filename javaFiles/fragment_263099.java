String string = "Hello World! This is a sample file.";
String[] strings = string.split(" ");
int[] counts = new int[30]; //Change this depending on how far you want to go
for(String str : strings)
     if(str.length() < counts.length) counts[str.length()] += 1;
for(int i = 1; i < counts.length; i++)
    System.out.println(i + " letter words: " + counts[i]);