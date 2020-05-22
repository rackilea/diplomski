ClassB.look(); // "B sees 10"
ClassC.look(); // "C sees 10"
ClassB.change();
ClassB.look(); // "B sees 42"
ClassC.look(); // "C sees 42"
ClassC.change();
ClassB.look(); // "B sees 67"
ClassC.look(); // "C sees 67"