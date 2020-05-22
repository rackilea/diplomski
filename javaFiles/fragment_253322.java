$.ajax({
     url:"http://localhost:8080/myServletPath/func?key=value",
     dataType: 'jsonp', // Notice! JSONP <-- P (lowercase)
     success:function(json){
         // do stuff with json (in this case an array)
         alert("Success");
     },
     error:function(){
         alert("Error");
     },
});