boolean foo(){ stream.peek(...).allMatch(..); }

//a violate rule
Stream<?> foo(){
  /*you need avoiding using peek() here since you can't control the stream*/
}