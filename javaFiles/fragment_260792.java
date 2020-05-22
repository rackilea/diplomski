void getCombiFor (int i, List <List <Integer>> li) 
{
     if (li.length > 0) 
     { 
        int idx = i % li.get (0).size ();        
        System.out.print (li.get (0).get(idx));                 
        getCombiFor (i - idx, li.remove (0));
     } 
     System.out.println ();
}   
// pseudocodeline:
List li = List (List ('a', 'b'), List ('c'), List ('d', 'e', 'f'))
for (int i = 0; i < 6; ++i) 
{
     getCombiFor (i, li);
}