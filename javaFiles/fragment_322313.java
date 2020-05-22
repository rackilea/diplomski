class ClassA {
    public ClassA() {
        UiApplication.getUiApplication().invokeLater(new Runnable() {
            public void run() {
                Dialog.inform("ClassA()");
            }
        });
    }
}

class ClassB extends ClassA {
    public ClassB() {
        super();
        UiApplication.getUiApplication().invokeLater(new Runnable() {
            public void run() {
                Dialog.inform("ClassB()");
            }
        });
    }
}

class ClassC extends ClassA {

}

class ClassD extends ClassA {
    public ClassD() {
        UiApplication.getUiApplication().invokeLater(new Runnable() {
            public void run() {
                Dialog.inform("ClassD()");
            }
        });
    }
}