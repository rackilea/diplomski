public static void main(string args[]){

}

//Note that the inputs are now declared as doubles.
public static  double quadraticEquationRoot1(double a, double b, double c) (){    
    double root1, root2; //This is now a double, too.
    root1 = (-b + Math.sqrt(Math.pow(b, 2) - 4*a*c)) / (2*a);
    root2 = (-b - Math.sqrt(Math.pow(b, 2) - 4*a*c)) / (2*a);
    return Math.max(root1, root2);  
}

public static double quadraticEquationRoot2(double a, double b, double c) (){    
    //Basically the same as the other method, but use Math.min() instead!
}