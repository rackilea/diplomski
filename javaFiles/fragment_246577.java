function sendFormData(endpoint) {
    console.log("CLICKING BUTTON");

    var input = {
            "userInputOne": "hello1", 
            "userInputTwo": "hello2", 
            "userInputThree": "hello3", 
            "userInputFour": "hello4", 
            "userInputFive": "hello5"
    }

    $.ajax({
        type:"post",
        //contentType: "application/json",
        data: input,//send data directly
        url: endpoint,
        asynch: false,
        success: function() {
            alert("success");
        } 

    });

}