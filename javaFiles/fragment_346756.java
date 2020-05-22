List<Node> nodes = new ArrayList<Node>();
   int aSize = a.getLength();
   int bSize = b.getLength();
   int cSize = c.getLength();
   if(aSize>0)
   {
       for (int i = 0; i < aSize; i++) 
           nodes.add(a.item(i));
   }
   ...