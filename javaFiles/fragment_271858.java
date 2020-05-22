$("#update").click(function(e) 
{
   e.preventDefault();
   var firstName = $("#firstName").val(); 
   var lastName = $("#lastName").val();
   var dataObject = {};
   dataObject.firstName = firstName;
   dataObject.lastName = lastName;

   $.ajax({
       type:'POST',
       data:dataObject,
       url:'returnData.php',
       success:function(data) 
       {
         alert(data);
       }
   });
});