int i = 0;
String val;
for(;;) {
  val = props.get("foo" + i);
  if (null == val) {
     break;
  }
  //process val
}