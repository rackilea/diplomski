$(function(){

    var serial_no = [];
    //init serial_no as what you want.
    for(var i=0; i<6; i++){
        serial_no.push(i+1);
    }

    //now set value into the textbox 
    $(".serialnocls").each(function(i){
        $(this).val(serial_no[i]);
    })

});