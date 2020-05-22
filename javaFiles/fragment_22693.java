function MyClass(options) { 
  // set up default options 
  var defaults = { 
    width: 10,
    height: 20
  }; 

  var options = $.extend({}, defaults, options);