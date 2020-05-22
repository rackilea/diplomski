$.ajax({
       type: 'POST',
       url:'search.action?searchText='+ $("#searchValue").val()+'&environment='+$("#environmentSelect").val(),
       dataType: 'json',
       success: function(data){
             console.log(stringify(data));
        }});