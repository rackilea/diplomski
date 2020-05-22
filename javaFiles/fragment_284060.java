private final Constructor const; // remove final, if required

public <ConstructorOfYourClassHere>(Constructor const) {
    assert const != null : "const != null"; // use assertions, if you like

    this.const = const;

    // other constructor code...
}

// your other code here...

public process(String base) {
    if("abc".equals(base)) {
        // ---
    }
    else if("def".equals(base) {
        extract();
        // ---
    }
}

private Obj extract() {
    Obj object = const.getOBJMethod("12345","c:/file/a.zip",null);
    return object;
}