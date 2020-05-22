class Wrapper{
  Part param1;
  File param2;
  File param3;
}

class Validator{
  void validate (Wrapper wrapper);
}


class ValidatorA extends Validate{
 void validate (Wrapper wrapper){
    //use wrapper.part... 
 }
}

class ValidatorC extends Validate{
 void validate (Wrapper wrapper){
    //use wrapper.file... 
     }
}