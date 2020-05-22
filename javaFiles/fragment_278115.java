$http({
        method : 'POST',
        url : 'login',
        contentType: 'application/json',
        data : JSON.stringify($scope.user),
    })...