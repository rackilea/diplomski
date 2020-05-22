// Retrieves user by name
function GetByUsername(username) {
    return $http.get('http://localhost:5555/demo/users/{name}' + username).then(
        handleSuccess, handleError('Error getting user by username'));
}

// Retrieves user by email
function GetByEmail(email) {
    return $http.get('http://localhost:5555/demo/usersByEmail/{email}' + email).then(
        handleSuccess, handleError('Error getting user by email'));
}