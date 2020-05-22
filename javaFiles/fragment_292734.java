while(inFile.hasNextLine()) 
            {

                Scanner sc = new Scanner(inFile.nextLine());
                sc.useDelimeter(" ");
                while(sc.hasNext())
                    System.out.println(sc.next());

            }