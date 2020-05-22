while(in.hasNext()){
                String s = in.next();

               String value = phonebook.get(s);
                if(value!=null)
                {
                  System.out.println(s+" : "+value);
                }
                else
                {
                 System.out.println("Not found");
                }
             }