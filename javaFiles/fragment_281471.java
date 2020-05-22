(function() { 
    var oldLog = console.log;
    console.log = function() { 
        oldLog.call(console, Array.prototype.slice.call(arguments).join(" "));
    }
})();