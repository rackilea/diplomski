$scope.DownloadFileFromServer = function(url){ //file server location


   var fileURL =  "/storage/emulated/0/DCIM/thefile.apk";

try{

var fileTransfer = new FileTransfer();
var uri = encodeURI("http://yourserver/yourCtrlName/file_download?filename=yourfilename");

fileTransfer.download(
    uri,
    fileURL,
    function(entry) {
        alert("download complete: " + entry.toURL());
    },
    function(error) {
        alert("download error source " + error.source);
        alert("download error target " + error.target);
        alert("download error code" + error.code);
    },
    false,
    {

      /*
        headers: {
            "Authorization": "Basic dGVzdHVzZXJuYW1lOnRlc3RwYXNzd29yZA=="
        }

        */
    }
);