function buscar(e){
    var url = 'https://www.dotscancun.com/createjson.php?id=100001';

    var xhr = Ti.Network.createHTTPClient({
        onerror: function(e){
            Ti.API.info(this.responseText);
            Ti.API.info(this.status);
            Ti.API.info(e.error);
        },

        timeout: 5000,

        onload : function(){
            alert(this.responseText);

            // parse it for further use
            var tempJSON = JSON.parse(this.responseText);
        }
    });

    xhr.open('GET',url);
    xhr.send();
}