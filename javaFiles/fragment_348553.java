.controller('navigation',
    ...
    var authenticate = function(credentials, callback) {

        var headers = credentials ? {
            authorization : "Basic "
                    + btoa(credentials.username + ":"
                            + credentials.password)
        } : {};

        $http.get('user', {
                ...