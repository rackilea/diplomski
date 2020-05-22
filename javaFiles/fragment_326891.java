function myFunction() {
    document.getElementById("res").innerHTML = "Result:" + txtCC1.value;
    var str = txtCC1.value;

    //Here i need a code to call my validation function 
    //like: var res=Validation (str);
    //and then do the  
    //document.getElementById("res").innerHTML = "Result:" + res;
    //DONE


     $.ajax({
        type: 'GET',
        url: './validate/'+str,   //Make sure you put the correct endpoint URL here!                
        success: function(data) { 
                    //DO SOMETHING HERE AFTER YOU GET THE RESPONSE FROM the validate function
                    document.getElementById("res").innerHTML = "Result:" + data;
                 },
        error: function(jqXHR, textStatus, errorThrown) {
                    //Do something on ERROR here                            
               }
    });

}