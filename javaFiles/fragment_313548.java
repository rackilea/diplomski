class Sum {

        public ArraryList<String> main() {
            // TODO Auto-generated method stub
             ArrayList<String> ac= new ArrayList<String>();
                ac.add("hai");
                ac.add("hw");
                ac.add("ai"); 
                ac.add("hi"); 
                ac.add("hai");
                Iterator it=ac.iterator();
                while(it.hasNext()) 
                {    
                    System.out.println(it.next()); 
                 }

                  return ac;
               }

    }