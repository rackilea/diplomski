$scope.uploadFile = function(){
    var formData=new FormData();
    formData.append("file",myFile.files[0]); //myFile.files[0] will take the file and append in formData since the name is myFile.
    $http({
        method: 'POST',
        url: '/upload', // The URL to Post.
        headers: {'Content-Type': undefined}, // Set the Content-Type to undefined always.
        data: formData,
        transformRequest: function(data, headersGetterFunction) {
            return data;
        }
    }).success(function(data, status) {  
    })
    .error(function(data, status) {
    });
}