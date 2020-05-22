class Main {
    public void runstuff() {
        labelX:
        for(...) {
            client.request(new Main$Foo().xyz(.....));
        }
    }

    class Foo {
         public xyz(....) {
             break labelX; // There is no labelX to break to here in Foo.xyz
         }
    }
}