String[] array = new String[100];
String str = null;
Scanner sc = new Scanner(System.in);
for (int i = 0; i < 100; i++) {       
    str= sc.nextLine();
    if(str.equals("stop")) {
        break;
    }
    array[i] = str;
}