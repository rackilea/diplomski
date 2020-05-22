function doSomething() {
  var arrDef = [];
  for (var i = 0; i < 2; i++) {
  var deferred = $.ajax({
        url:"https://jsonplaceholder.typicode.com/todos/1",
        type: "GET",
        contentType: "application/json;odata=verbose",
        success: function(data) {
          console.log('complete');
        },
        error: function(data) {
          console.log('fail');
        }
      }).promise();
      
    arrDef.push(deferred);
  }
  return arrDef;
}

  var getters = doSomething();
  // use apply to call $.when 
  $.when.apply(this, getters).then(function() {
    console.log('Final complete');
    // correctly writes out all responses
  });