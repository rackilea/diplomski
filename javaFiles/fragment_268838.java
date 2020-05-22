public ArrayList<JTable> getTable()
  {
        return List;
  }

 public void AddT(JTable tl)
 {
     if(tl.getName()!=null)
     {getTable().add(tl);}
     else return;
 }