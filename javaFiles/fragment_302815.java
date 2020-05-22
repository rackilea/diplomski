success : function(data) {
          var nameArray = [];
          $.each(data,function(key,val){
                nameArray.push({value:val.Name, label:val.Name, id: val.id});
           });

           response(nameArray);
}