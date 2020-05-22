$scope.formSubmit=function(){
        alert("submitted")

        return $http({
            url :'loginSubmit?username='+$scope.username+'&password='+$scope.password ,
            method : "POST",
        }).success(function(data, status, headers){

        }).error(function(data, status, headers) {
            console.log("login error"+status);     
     }); 

    }