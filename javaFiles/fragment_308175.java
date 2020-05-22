Person person = new Person();
  Field[] fields = person.getClass().getFields();

  for(Field field : fields){
      DesiredField annotation = field.getAnnotation(DesiredField.class);
      if( annotation != null ){
          // This is desired field now do what you want
      }
  }