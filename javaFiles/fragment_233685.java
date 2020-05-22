public void addAndInsert(String query)  
{
      synchronized(list)
      {
           list.add(query);
           if(list.size() >= 1000)    
           {
                writeIntoDatabase(list);
                list.clear();
           }
      }
}