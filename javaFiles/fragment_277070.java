$scope.postData = function() {

     var data = escape(angular.toJson($scope.items));

     $http({
          method: 'POST',
          url: '/StrutsWithAngular/shopingCart.do',
          data: 'cartValues='+data,
          headers: {'Content-Type': 'application/x-www-form-urlencoded'}
       }).success(function(data, status, headers, config) {
            $scope.items = data;
       }).error(function(data, status, headers, config) {
        // alert("Error :: "+data);
       });
};