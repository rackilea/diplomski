Scanner input = new Scanner(System.in);
String s1 = input.nextLine();
String s2 = input.nextLine();
String s3 = input.nextLine();
int i1 = sumLetter(s1);
int i2 = sumLetter(s2);
int i3 = sumLetter(s3);
StringWithUppercaseSize[] sizes = { new StringWithUppercaseSize(s1, i1), new StringWithUppercaseSize(s2, i2), new StringWithUppercaseSize(s3, i3) };