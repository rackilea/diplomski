// get the canvas for manipulation
var canvas = document.getElementById("myCanvas");
var context = canvas.getContext('2d');

// draw a square this is just a test
context.moveTo(5,5);
context.lineTo(395,5);
context.lineTo(395,195);
context.lineTo(5,195);
context.lineTo(5,5);
context.fillStyle = "#FF0000";
context.fillRect(5,5,390,190);
context.stroke();

// create the image and set the attributes
var image = new Image();
image.src = canvas.toDataURL('jpeg', 1.0);
image.alt = "A simple red rectangle with black border";
image.title = "Red rectangle with black border";
image.width = 400;
image.height = 200;
image.className = "myClass";

// place the image inside the div
document.getElementById('imagediv').appendChild( image );