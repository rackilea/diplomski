function download() {
    var token = new Date().getTime();
    var wait = document.getElementById("wait");
    wait.style.display = "block";

    var pollDownload = setInterval(function() {
        if (document.cookie.indexOf("download=" + token) > -1) {
            document.cookie = "download=" + token + "; expires=" + new Date(0).toGMTString() + "; path=/";
            wait.style.display = "none";
            clearInterval(pollDownload);
        }
    }, 500);

    window.location = "download?token=" + token;
}