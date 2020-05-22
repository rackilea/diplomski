enum Foo { GOOD_FOO, BAD_FOO }
enum Switcharoo { BAR, BAZ, BAQ, ESCAPE }
enum Size { NONE, REGULAR, BIGGER }

Foo foo = ... // assigned somewhere
Switcharoo roo = ... // assigned somewhere
Size size = NONE;

// use a while loop to reevalulate roo with each pass
while(roo != Switcharoo.ESCAPE) {
    switch(roo){
        case BAR:
                switch(foo) {
                    case GOOD_FOO: foo = doSomething(foo); break;
                    case BAD_FOO: foo = doSomethingElse(foo); break;
                }
            break;
        case BAZ:
            roo = Switcharoo.ESCAPE;
            size = Size.REGULAR;
            break;
        case BAQ:
            roo = Switcharoo.ESCAPE;
            size = Size.BIGGER;
            break;

    }
}