function callNativePlugin(callback) {
   cordova.exec(function(result) {
       callback(null, result);
   }, function(result) {
       callback("myerror");
   }, "Database", "saveAdvertencia", [ 1, "TesteAdv" ])
};