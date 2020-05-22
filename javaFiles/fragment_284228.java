yourAppName.controller('myController' , [$http , $scope , function($http , $scope)
{
 var paramValue = [];
 paramValue['par'] = $scope.someValue;
$http.get('rest/getdata' , {params : paramValue}).success(function(data)
{
   $scope.myData = data;

}).error(function(data)
{
   console.log('error occured');

});

}]);