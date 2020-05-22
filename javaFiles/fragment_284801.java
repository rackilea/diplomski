function sprintf(string) {
  var args = Array.prototype.splice.call(arguments, 1);

  for (var i = 0; i < args.length; i++) {
    if (!isNaN(args[i])) {
      args[i] = new java.lang.Integer(args[i]);
    }    
  }

  return java.lang.String.format(String(string), args);
}