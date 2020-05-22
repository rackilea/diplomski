String s = input.readLine();
checkReadLineNotNull(s);
int a = 0, p = 0, b = 0;
StringTokenizer st = new StringTokenizer(s);
int count = Integer.parseInt(st.nextToken());

for (int i = 0; i < count; i++) {
    s = input.readLine();
    checkReadLineNotNull(s);
    st = new StringTokenizer(s);
    //...
}

//Checks if s != null otherwise kills the programm
private static void checkReadLineNotNull(String s) {
    if(s == null){
        //File is empty abort
        System.out.println("The file is empty");
        System.exit(0);
    }
}