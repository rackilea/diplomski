function getContextPath() {
   return window.location.pathname.substring(0,  window.location.pathname.indexOf("/",2));
}
...
var img = new Image();
img.src = getContextPath() + "/app/images/springboot.png";
document.getElementById('div').appendChild(img);