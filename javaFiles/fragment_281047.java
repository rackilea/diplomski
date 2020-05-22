class Big {

    private Object magic_field;

    public Object magic_method (int _idx){            
         if (_idx == 1){
             magic_field = new Object_1();
         }
         else if (_idx == 2){
             magic_field = new Object_2();
         }
         ...
         else if (_idx == N){
             magic_field = new Object_N();
         }
         return magic_field;
    }   
}

class Object_1 {
//...
}

class Object_2 {
//...
}

class Object_N {
//...
}