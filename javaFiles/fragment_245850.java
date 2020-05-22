$(document).ready(function () {
           $("#login-btn").click(function () {
               $.ajax({
                   type: "POST",
                   url: "login",
                   data : $("#myform").serialize(),
                   success: function (data) {
                       alert(data);
                   },
                   error: function(data){
                       alert(data);
                  }
               });
           }) 
        });