$scope.submitForm = function() {
    console.log($scope.blob); // result:{"ancestor":[1,2,3,4]} 
    $http({
        url: 'http://localhost:8080',
        method: "POST",
        params: {
            ancestor: $scope.blob.ancestor
        }
    }).success(function(data) {
        console.log(data);

    }).error(function(data) {
        console.log(data);
    });
}