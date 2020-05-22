$.ajax({
      url: "/bin/test/redirect",
      success: function(result){
          if(result.redirect){
              window.location = result.location;
          }
      },
      error: function(result){
          alert("Redirection Failure");
      }
  });