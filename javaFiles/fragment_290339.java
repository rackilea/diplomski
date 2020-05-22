//1. first ajax request 
$.ajax({
  type: "GET",
  url: "htt://yourwebsite.com",
  success:function(result){
   //2. when data will arrive this method is executed with data in result argument.

   //do what ever with data.

   //3. make other ajax request.
      $.ajax({
             type: "GET",
              url: "htt://yourwebsite.com",
          success:function(result2){

               //4. final response.. will arrive here in result2
                }
            });

  }
});