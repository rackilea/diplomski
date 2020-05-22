$(".serial").live("blur", function(){
//got the index of textbox where serial number is entered
var index = $(".serial").index(this);

$.ajax({
 url:"validateSN",
 data: "value="+sn,
 success : function(data){
 $("#validsn"+index).show();
     if(data=="true"){
    $("#validsn"+index).attr('src',"images/icons/valid_icon.png");
     } else if(data=="false"){
        $("#validsn"+index).attr("src", "images/icons/invalid_icon.png");
     }
});