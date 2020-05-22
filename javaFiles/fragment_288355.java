.sortBy(new Function<Person, Integer>(){
      @Override
       public Integer apply(Person p){ 
           return -p.getAge();
      }
})...