const start = function (data, resolve, reject) {
    let child = exec('java -jar java/out/artifacts/decrypter_jar/decrypter.jar ' + data,
    function (error, stdout, stderr){
        console.log('Output -> ' + stdout);
        if(stdout){
            resolve(stdout);
        }
        else {
            reject('Empty response from JAR');
            return;
        }
        if(error !== null){
            console.log("Error -> "+error);
            reject(error);
        }
    });


};

module.exports = {start};