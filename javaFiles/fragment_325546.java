$(document).ready(function(){

    $("#val").keydown(function(e){
            if(e.which == 9) {
            e.preventDefault();
            $("p").html("focus event triggered");        
        }
    });  
    $("#btn1").click(function(){
        $("#val").focus();
        $("p").html("focus event triggered");
    });  
    $("#btn2").click(function(){
        $("input").blur();
        $("p").html("blur event triggered");
    }); 
});