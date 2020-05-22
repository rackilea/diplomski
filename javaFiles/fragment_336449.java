function cosh(x) { return 0.5*(Math.exp(x)+Math.exp(-x)); }
function sinh(x) { return 0.5*(Math.exp(x)-Math.exp(-x)); }

function rgb(r,g,b) { return "rgb("+r+","+g+","+b+")"; }
var colors = new Array(24);
for(var k=0; k<8; k++) {
    colors[   k] = rgb(k*64,(7-k)*64,(7-k)*64);
    colors[ 8+k] = rgb((7-k)*64,k*64,(7-k)*64);
    colors[16+k] = rgb((7-k)*64,(7-k)*64,k*64);
}

var cvs = document.getElementById('sine-fractal');
var ctx = cvs.getContext('2d');
var cx = 0.0, cy = 0.0;
var dx = 1.0;

var tiles = 100;
var scale = Math.min(cvs.width, cvs.height) / tiles;
ctx.scale(scale, scale);

function localx(i) { return cx-dx + 2*i*dx/tiles; }
function localy(j) { return cy-dx + 2*j*dx/tiles; }

for (var i = 0; i < tiles; i++) {
  var a = localx(i);
  for (var j = 0; j < tiles; j++) {
    var b = localy(j);
    var r2 = a*a + b*b;
    var x = a, y = b;
    var rounds = 0;
    var max = 500;
    while (x * x + y * y < 4 && rounds < max) {
      var u = (a*x + b*y) / r2, v = (a*y - b*x) / r2;
      x = Math.sin(u) * cosh(v);
      y = Math.cos(u) * sinh(v);
      rounds++;
    }
    ctx.fillStyle = colors[rounds % 24];
    ctx.fillRect(i, j, 1, 1);
  }
}