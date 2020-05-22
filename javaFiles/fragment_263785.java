// assuming `id` is a string here
function liftOff(id) {

  alert("Before Delete");

  // You'll have to setup this endpoint to run 
  // your `DAO_Object.deleteRecord(ID);` code 
  // in your JSP code.

  $.get("/delete/my/record/" + id, {
    error: function(e){
      // some kind of error occurred in making the request
    },
    success: function(resp){
      // `resp` is the response from the server
      alert("After Delete");
    }
  });
}