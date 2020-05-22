try {
            Scanner s = new Scanner(new File("script.txt"));
            System.out.println(s.nextLine()); //<-- HERE YOU PRINT FIRST!
            int i = 0;
            if (s.hasNext()){
                i = s.nextInt();
            }
            i = 5;
            System.out.println(i); //<-- HERE YOU PRINT THE SECOND NUMBER!

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }