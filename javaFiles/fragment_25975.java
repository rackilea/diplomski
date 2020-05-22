//new class
function Rectangle(width, height) {
    //class properties
    this.width = width || 1;
    this.height = height || 1;
}

//class functions
Rectangle.prototype.area = function () {
    return this.width * this.height;
}

//create a new Rectangle object
var bigRec = new Rectangle(42, 100);
//call functions created from the prototype
alert(bigRec.area());