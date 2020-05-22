function loadImages(images) {
    var src = document.getElementById("image-container");
    images.foreach(function(imageUrl) {
        var img = document.createElement("img");
        img.src = "image.png";
        src.appendChild(img);
    });
}