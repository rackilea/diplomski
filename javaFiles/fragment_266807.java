function checkmessage(){
    $.ajax({
        type: "POST",
        url: "page.php",
        data: "function=getMessages",
        success: function(msg){
            alert(msg);
            if(msg == "noMessage"){
                //do nothing
            }else{
                //should do some validation on error handling
                //then use jquery to print msg
            }
        },
        error: function(msg){
            alert('Error: cannot load page.');
        }
    });
    setTimeout("checkmessage()",3000);
}