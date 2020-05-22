class Scr extends MainScreen {

    protected void makeMenu(Menu menu, int instance) {
        super.makeMenu(menu, instance);

        menu.add(new MenuItem("class A", 0, 0) {
            public void run() {
                ClassA a = new ClassA();
            }
        });
        menu.add(new MenuItem("class B", 0, 0) {
            public void run() {
                ClassB b = new ClassB();
            }
        });
        menu.add(new MenuItem("class C", 0, 0) {
            public void run() {
                ClassC c = new ClassC();
            }
        });
        menu.add(new MenuItem("class D", 0, 0) {
            public void run() {
                ClassD d = new ClassD();
            }
        });
    }
}