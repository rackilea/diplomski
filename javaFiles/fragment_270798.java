while(true)
        {
            System.out.println("Please Enter Age:");
            int howOld = sken.nextInt();
            System.out.println("Please Enter Name:");
            String name = sken.next();
            String thisLine = sken.nextLine();
            hashMap.put(howOld, name); 

            System.out.println("Do you want the results (Y/N)?");
            String more= sken.next();
            if(more.equals("N") || more.equals("n")){
                break;
            }
        }