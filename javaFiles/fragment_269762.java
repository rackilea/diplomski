function Foo() {}
Foo.prototype.hello = function() { alert('hello'); };

var f = new Foo();
f.hello(); // alerts 'hello'

delete Foo.prototype.hello;

f.hello(); // throws an error