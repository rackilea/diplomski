function padZero (num:Number, digits:int):String {
  var ret:String = num.toString();
  while (ret.length < digits)
    ret = "0" + ret;
  return ret;
}