// define a functional interface which we will use
public Interface MathFunction {
    public double apply(double d);
}   

// declare our array of functions, using three lambda functions to statically declare
// the array
MathFunction[] functions = {x -> {return Math.cos(x);}, 
                            x -> {return Math.sin(x);},
                            x -> {return Math.tan(x);}};