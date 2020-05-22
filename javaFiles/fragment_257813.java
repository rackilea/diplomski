if(!pattern_has_wildcard){
  if(foo != 0)
    dir+="/";
  v.addElement(dir+Util.unquote(_pattern));
  return v;
}