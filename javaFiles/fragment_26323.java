private String[] availablePackages={"business", "pay", "demo"};

public getMenuClass() {
    Class c;
    for(String package : availablePackages) {
        try {
            c=Class.forName("com.meh.myapp."+package+".MenuClass");
        } catch... {
            // No package by that name
        }
        if(c != null) {
            return c.newInstance();
        }
    }
    // Something went wrong, no instance found.