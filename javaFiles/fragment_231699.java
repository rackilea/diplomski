static String[] plannedruns(){
         //job ID is taken as String
        String[] runs=new String[50]; 
        //Writes instructions in console
        System.out.println("Instructions"+"\n"+"Please enter Job ID's that planned for this month (Mazimum 50 jobs)"+"\n"+"At the end of the list, enter 0");
        // Scanner to take inputs
        Scanner scanner = new Scanner(System.in);
        int i=0;
        //takes job ID inputs
        for(int position=0;position<50;position++){
            System.out.print("Enter Job ID for Job " + ++i +" : ");
            runs[position]=null;
            runs[position] = scanner.nextLine();
            try{
                    if (runs[position].equalsIgnoreCase("end")){
                        runs[position]=null;
                    break;
                }
                for(int j=0;position>j;j++){
                    //1
                    System.out.print(runs[j].equals(runs[position]));
                    if(runs[j].equals(runs[position])){
                        System.out.println("One job repeated. Please enter the run correctly");
                        --i;
                        --position;
                    }
                }

            }
            catch(Exception e){                
            }
        }
        //Print before printing job details
        System.out.println("These are the entered jobs for this month");
        i=0;
        for(int position=0;position<50;){
            try{
                if (runs[position]==null){
                    break;
                }
            }
            catch(Exception e){            
            }
            System.out.println("Job No."+ ++i +" is "
                    + ""+runs[position++]);

        }
        System.out.println("end");
        return runs;
    }