public static double quadraticEquationRoot2(int a, int b, int c){
    double root1 = (-b + Math.pow( b*b - 2*a*c , .5))/(2*a);
    double root2 = (-b - Math.pow( b*b - 2*a*c , .5))/(2*a);
    //we have options here, use min/max, or use if statements, for example. With ifs:
    if ( root1 < root2 ){
        return root1;
    }
    return root2;
    //otherwise: return min( root1, root2 );
}