%typemap(jstype) StrArrHandle "String[]";
%typemap(javaout) StrArrHandle {
  $javaclassname tmp = new $javaclassname($jnicall, $owner);
  // You could use the moduleimports pragma here too, this is just for example
  java.util.ArrayList<String> out = new java.util.ArrayList<String>();
  for (String s = tmp.next(); s != null; s = tmp.next()) {
    out.add(s);
  }
  return out.toArray(new String[out.size()]);
}