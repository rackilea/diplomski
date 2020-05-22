Scanner sc2 = new Scanner(f);
   boolean flag = false;
   while (sc2.hasNextLine() && !flag) {
        String str = sc2.nextLine();
        if(str.contains("@Test")){
            flag = true;
        }
  }
  if(flag) {
        System.out.println("this a test clsee!");
  }