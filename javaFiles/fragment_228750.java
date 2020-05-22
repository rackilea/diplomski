$.ajax({
    method: "POST",
    url: "/myServlet",
    data: { category: $("#category").val()} //post category field
}).done(function( msg ) {
    alert( msg ); //alert html returned from servlet 
});