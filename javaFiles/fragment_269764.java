function Thing() {}

var randomObject = { foo: 1, bar: 2 };
Thing.prototype = randomObject;

var thing = new Thing();
thing.foo; // 1