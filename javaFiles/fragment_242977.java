class Myclass extends JFrame{
    blah blah ...
    JLabel lblFx =new JLebel("f(x=)");
    JTextfield Fx = new JTextField();
    String formula = Fx.getText();//2*x+1  OR  cos(x) OR lot of other functions

    //and lets say that this method calculate the f(x).
    //get as argument the x
    double calculateFx(double x){
        // The Expr Object that will representing the mathematical expression
        Expr expr = null;

        try {
            // parsing function formula to mathematical expression
            expr = Parser.parse(formula);
        } catch (SyntaxException e) {
            System.err.println(e.explain());
            return;
        }

        // Define(make) what will be the variable in the formula, here x
        Variable vx = Variable.make("x");
        // Set the given value(x) in variable
        vx.setValue(x);

        //return (mathematical) expression's value. See more for Expr lib how work...
        return expr.value();//
    }

}