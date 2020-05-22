$("#button").click(function() {
    "use strict";
    var randomNumber = Math.floor(Math.random()*44);
    $("#place"+randomNumber).show("slow", function(){
        alert=("New Place");
    });
});