things: function() {
        return $http.get('/things')
            .then(
                function(response) {
                    return response.data;
                },
                function (errResponse) {
                    return $q.reject(errResponse);
                }
            );
    },