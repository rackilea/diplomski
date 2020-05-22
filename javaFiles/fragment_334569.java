@Override
double apply(double x, double y) {
//  now the superclass is searched
//  but the target reference is definitely 'this'
//  vvvvvv
    super.printMe(x);
    return x + y;
}