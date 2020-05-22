for(int i=0;i<hits.length;++i){ 
      int docId = hits[i].doc; 
      if(Total_Hits.keySet().isEmpty() == true)
          {
            Total_Hits.put(docId,1);
          }
      else 
         {
            if(Total_Hits.containsKey(docId))
                {Total_Hits.put(docId,Total_Hits.get(docId).intValue()+1);}
            else
                { Total_Hits.put(docId,1);}

         }