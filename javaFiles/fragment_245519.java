function getAPIArray(callback) {
    var url = "https://someurl";
    $.ajax({
        type: 'GET',
        url: url,
        success: function (data) {
            //data will be the response from the server (the api's)
            // If it's not already in a list (array) then you have to build it up
            //Example:
            var array = [];
            for (var i = 0; i < data.results.length; i++) {
                array.push(data[i].apiName);
            }
            callback(array);
        },
        error: function (err) {
            alert('error!');
            console.log(err); //prints error object to console
        }

    });
}

function getsCalledWhenFinished(apiArray) {
    //do whatever you want with the data..
}

getAPIArray(getsCalledWhenFinished); //invokes the ajax call