@play.db.ebean.Transactional 
     public static void delete(Class2 class2)
  {  
     List<Class3> list = class2.getClass3s();
     for(int i = 0; i < list.size(); ++i)
     {
       Class3.delete(list.get(i));
     }  
     list.clear();
     class2.getClass1().getClass2s().remove(class2);
     class2.delete();
    }