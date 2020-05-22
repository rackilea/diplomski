Iterator Iter = UIMA.iterator();

vc = new ArrayList(); // HERE is where you need to create your vc object
while (Iter.hasNext()) 
{
    FirstName fn = (FirstName) Iter.next();
        String name=fn.getName();//It will return the name 
        vc.add(name);
       System.out.println(name);
     }
     return vc;