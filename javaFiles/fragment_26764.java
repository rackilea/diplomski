$(document).ready(function(){
    $(".changeAction").on("click", function(){
        $('.changeable').html('')
        var divId = $(this).attr("div-id");
        $("#dynamicName").val(divId);
        divId = "#"+divId;
        var myInput = '<label for="Node"> Node </label> <input type="text" name="node" size="20" /> <label for="Data"> Data </label> <input type="text" name="data" size="100"/>'
        $(divId).html(myInput);
    })
})