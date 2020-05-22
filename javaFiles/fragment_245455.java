for (<TypeOfYourItems> item : list)
  {    
    if(!contactModels.contains(item))
       {
        databaseadapter.removeContact(item);
       }
  }