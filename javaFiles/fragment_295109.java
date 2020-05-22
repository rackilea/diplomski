String fromNode = samling.get(to).getNode();
   djikstaList.add(to);
   while(fromNode != from){   
       fromNode = samling.get(fromNode).getFrån();
       djikstaList.add(fromNode);
   }