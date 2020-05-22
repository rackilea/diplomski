String file="save.txt";        
    Scanner sc2 = null;
    try {
        sc2 = new Scanner(new File(file));
    } catch (FileNotFoundException e) {
        e.printStackTrace();  
    }
    while (sc2.hasNextLine()) {
        Scanner sc3 = new Scanner(sc2.nextLine());            
        String a=sc3.next();
        String b=sc3.next();
        String c=sc3.next();
        String d=sc3.next();           

        if (a.equals(sh)){ //have to use the .equals to compare strings
            System.out.println(a+" "+b+" "+c+" "+d);
            ctr++;
        }
    }