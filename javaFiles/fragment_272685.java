class response {
  String status;
}

class simpleResponse extends response {
  String data;
}

class listResponse extends response {
  ArrayList<Type> data;
}

class MyDeserializer extends JSONDeserializer<E extends response> {
   public E deserialize...) {

   }
}