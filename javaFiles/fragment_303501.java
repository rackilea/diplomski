function Animal(name) {
  this.name = name;
}
Animal.prototype.alive = true;
function Ursine(name, colour) {
  Animal.call(this, name); // call superconstructor to handle initialisation
  this.colour = colour;
}
Ursine.prototype = Object.create(Animal.prototype);
Ursine.prototype.sound = function growl() { console.log("Grrrr"); }

function PolarBear(name) {
  Ursine.call(this, name, "white");
}
PolarBear.prototype = Object.create(Ursine.prototype);
var sheet = new PolarBear("Sheet");
sheet.name;
// Sheet
sheet.colour;
// white
sheet.sound();
// "Grrrr"
sheet.alive
// true

function Cat(colour) {
  this.colour = colour;
}
Cat.prototype = Object.create(Animal.prototype);
Cat.prototype.sound = function meow() { console.log("meow"); }
var fluffy = new Cat("grey");
fluffy.alive
// true
fluffy.sound()
// "meow"