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

// set the image as the href of the anchor
document.getElementById("myA").href = canvas.toDataURL('jpeg', 1.0);