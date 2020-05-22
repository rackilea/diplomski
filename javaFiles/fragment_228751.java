$("btnSubmit").click(function(event){
    event.preventDefault();
    $.get("/myServlet", function(data, status){
        alert("Data: " + data + "\nStatus: " + status);
    }); 
});