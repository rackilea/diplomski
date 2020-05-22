postFile(file) {
    var postData = new FormData();
    postData.append('File', file);

    var params = {
    headers: {
        "Content-Type": undefined
    }

    $http.post(url, data, params).then([...]);
}