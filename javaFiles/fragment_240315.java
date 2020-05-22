<html>
<body>
<script>
Array.prototype.randomElement = function () {
    return this[Math.floor(Math.random() * this.length)]
}
var list1 = [ "1", "2", "3", "4", "5", "6", "7", "8", "9"];
var list2 = [ "a", "b", "c", "d", "e", "f", "g", "h", "i"];
var list3 = [ "car", "horse", "gym", "fair", "boat"];

function myFunction() {
    document.getElementById("demo").innerHTML = list1.randomElement() + " " 
    + list2.randomElement() + " " + list3.randomElement();
}
</script>
<p><p id="demo"></p></p>
<button onclick="myFunction()">Click me</button>
</body>
</html>