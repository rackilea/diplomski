// #1
var Car = function(type, model, color) {
    this.type = type;
    this.model = model;
    this.color = color;
}

var car = new Car("Fiat", 500, "white");

// #2
var car = {type: "Fiat", model: 500, color: "white"};

// For either option, to get the color you can simply:
console.log(car.color);