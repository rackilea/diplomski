public Optional<T> get(int index) {    
       if(index > -1 && index < array.length)
           return Optional.ofNullable(array[index]);
       else
           System.out.println("Invalid Index");  

       return Optional.empty();
}