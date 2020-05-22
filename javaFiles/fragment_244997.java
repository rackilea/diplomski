$scope.login = function() {
    url = '/login';
    $http.post(url,{
        "user":$scope.user,
        "pass":$scope.pass  
    }).then(function (response) {
        if(response) {
            $location.path('/main');
        } else {
            $location.path(url);
        }
    });
};