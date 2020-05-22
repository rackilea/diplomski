this.addEmployee = function (requestData, file) {
    var data = new FormData();
    data.append('file', file[0]);
    data.append('requestData', new Blob([JSON.stringify(requestData)], {
        type: "application/json"
    }));

    var config = {
        transformRequest: angular.identity,
        transformResponse: angular.identity,
        headers: {
            'Content-Type': undefined
        }
    }
    var url =  "http://localhost:8080/addEmployee";
    var promise1 = $http.post(url, data, config);
    var promise2 = promise1.then(function (response) {
        return response.data;
    },
        function errorCallback(response) {
            alert(response.data.errorMessage);
        });
    return promise2;
}