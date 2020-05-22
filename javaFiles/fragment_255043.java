$.ajax({
    url: "../dataExchange",
    type: "post",
    data: {date: Date, action: "doTheSelect"},
    dataType: 'json', 
    success: function(data){
        alert("success");
        $("#result").html('submitted successfully');

        // do something with variable - data(returned json object)
    },
    error:function(){
        alert("failure");
        $("#result").html('there is error while submit');
    }   
});