if(!pattern_has_wildcard){
  if(!dir.equals("/"))
    dir+="/";
  v.addElement(dir+Util.unquote(_pattern));
  return v;
}