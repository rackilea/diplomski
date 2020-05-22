$('#follow_me').on('click',function(){
  $.ajax(
     url : url,   // Controller URL
     data : user_id, // Current User ID
     follow_Flag : true,
     success: function(result){
          //Code for changing the view(JSP)
      }});
  );
});