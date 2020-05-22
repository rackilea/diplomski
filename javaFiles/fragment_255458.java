$.ajax({
   url: "<s:url namespace="/aaa" action="bbb"/>",     
   data : {key: value},
   dataType:"json",
   success: function(json){
     $.each(json, function( index, value ) {
       alert( index + ": " + value );
     });
   }
});