interface io {
    public void show();
}

abstract class Demo {
    abstract int show();         
}

class Test extends Demo implements io {  
    void show () {     //Overloaded method based on return type, Error
    }

    int show() {       //Error
        return 1;
    }

    public static void main (String args[]) {

    }
}