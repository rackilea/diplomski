abstract class MiddleType extends Type implements Middle { }

class Subtype1 extends MiddleType { }
class Subtype2 extends MiddleType { }
...

class Handler<T extends Root, S extends MiddleType> {  //...