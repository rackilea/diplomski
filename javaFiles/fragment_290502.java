Myservice.addNew().save($.param({
        name:$scope.name
    }),function(data){
        console.log(data);
    },function(err){
         console.log(err);
    });