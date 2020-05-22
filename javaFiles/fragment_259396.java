$("button").click(function(){
        $.post("Serve",
          {
            name: "Donald Duck",
            city: "Duckburg"
          },
          function(data, status) {
            alert("Data: " + data + "\nStatus: " + status);
          }
        );