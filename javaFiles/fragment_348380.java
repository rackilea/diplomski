class Wool {

    int add() {
        int x = 0; // give a value to avoid another error
        int a = x + 3;
        return a;
    }

    public static void main (String [] args) {  
        Wool w = new Wool ();
        System.out.print("something here " + w.add());
    } // end main

} // end class