String names[] = {"George", "Bill"};
        for(String name:names){          
             jobs.put(name, jobReader(name));              
        }

       public ArrayList jobReader(String name){
        ArrayList<String> tasks = new ArrayList<String>();
                tasks.add("Tidy");
            return tasks;
    }