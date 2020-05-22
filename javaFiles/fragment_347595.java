private final Supplier<T> supplier;
   public MessageType(Supplier<T> supplier){
       this.supplier = supplier;
   }
   public T newType(){
      return supplier.get();
   }

   MessageType<String> STRINGS = new MessageType(String::new);
   MessageType<List<String>> STRING_LIST = new MessageType(ArrayList::new);