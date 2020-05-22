Singleton instance = Singleton.getInstance();
  objectOutputStr.writeObject(instance);
  Singleton singleton1 = (Singleton) objInputStr.readObject();
  objectOutputStr.writeObject(instance); //Added an additional write to stream
  Singleton singleton2 = (Singleton) objInputStr.readObject();
  System.out.println(singleton1);//A
  System.out.println(singleton2);//B