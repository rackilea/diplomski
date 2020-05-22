Scanner sc2 = new Scanner(f);

while (sc2.hasNextLine()) {

    count++;

    String str = sc2.nextLine();

    for (int i = 0; i < str.length(); i++) {
        if(str.equals("@Test")){
        System.out.println("this a test clsee!");