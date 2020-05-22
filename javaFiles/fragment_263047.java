public interface MyCallback { 
  public void doSmth( String val ); 
}

...

HashMap<String, MyCallback> hashMap = new HashMap<>();
hashMap.put( "42", new MyCallback(){
  @Override doSmth( String val ){ System.out.println( val ); }
} );

hashMap.get( "42" ).doSmth( "ultimate question" );