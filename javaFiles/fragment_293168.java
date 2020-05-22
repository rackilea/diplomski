Scanner in = new Scanner(System.in);

String[] first = in.nextLine().split(":");
String[] second = first[1].split(";");
String[] thirdA = second[0].split("=");
String[] thirdB = second[1].split("=");

for(int i = 0; i < thirdA.length; i++){
    System.out.println(thirdA[i]);
    System.out.println(thirdB[i]);
}