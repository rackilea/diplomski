this.debugGet = function(server, client, numObjects){       

    var httpProm = $http({
        method: "GET",
        url: "debugGet",
        timeout: client,
        params : {
            timeout: server,
            numObjects: numObjects}
    });             

    httpProm.then(function(data){
        console.log(data);
    }, function(data){
        console.log("error");
        console.log(data);
    });     
};