Employee e = Optional.of(obj).map(o -> { 
     Employee tmp = new Employee(); 
     tmp.setFirstName(o[0]);
     tmp.setLastName(o[1]);
     return tmp; 
}).get();