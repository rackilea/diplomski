$.ajax({
          type: 'POST',
          url:'search.action?searchText='+ document.getElementById('searchValue').value  +'&environment='+document.getElementById('environmentSelect').value,
          dataType: 'json',
          success: function(data){
          console.log(stringify(data));
          }});