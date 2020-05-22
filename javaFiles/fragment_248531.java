function drawImage(imgString){
    var canvas = document.getElementById("canvas");
    var ctx = canvas.getContext("2d");

    var image = new Image();
    image.src = imgString;
    image.onload = function() {
        ctx.drawImage(image, 0, 0);
    };
}