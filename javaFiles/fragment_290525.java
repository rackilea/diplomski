interface Wrapable { // replace Wrapable with something more appropriate
   // common methods here?
}

class B implements Wrapable {

}

class A implements Wrappable {
    Wrappable whatThisWraps;

    A(Wrappable w) { whatThisWraps = w; }
}