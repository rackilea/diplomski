//define the callback function
var callbackFunction = function(err, result) {
    if (err) {
        console.log("there was an error");
    } else {
        console.log("success", result);
    }
};

//call the plugin
callNativePlugin(callbackFunction);