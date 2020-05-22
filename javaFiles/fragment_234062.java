data = {
   restaurant:{
      //rest props
   },
   type: {
      //type props
   },
};

$.ajax({
        type : "POST",
        url : "http://localhost:8080/Appetizers_project/rest/restuarant",
        data : JSON.stringify(data),
        success : function() {

            alert();
        },
        error : function() {
            alert("ERROR Occured");
        },
        dataType : "json"
    });