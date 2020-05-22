$.ajax({
   type : 'POST',
   url : 'method url',
   data : form.serialize(),
   success : function(data){
       // data is the object inserted
   }
});