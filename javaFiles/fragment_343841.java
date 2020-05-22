//Default constructor
public Quadratic()
{
    //1.
    a = 0;
    b = 0;
    c = 0;
    posX = 0;
    negX = 0;
}

public Quadratic(double a, double b, double c){
    //2.
    this.a = a;
    this.b = b;
    this.c = c; 
    this.posX = 0;
    this.negX = 0;
}


//The mutators
public void setQuad(Double alpha, double bravo, double charlie)
{
   a = alpha;
   b = bravo;
   c = charlie;
   getQuad();
}

public void getQuad()
{
   //4.
    double temp = (Math.pow(b, 2) - (4 * a * c));//getting the number inside the root

    if(temp < 0)
        temp = Math.abs(temp);
    //ensures that the function can run until complex numbers are sorted

    posX = (-b + (Math.sqrt(temp)))/(2 * a);

    //3.
    negX = (-b - (Math.sqrt(temp)))/(2 * a);
}

//Accesors  5.
public double getA(){
    return this.a
}

public double getB(){
    return this.b
}

public double getC(){
    return this.c
}
//Overriding toString
public String toString()
{
    if(negX == posX)
        return "X = "+ negX;
    else
        return "X = "+ negX +" and "+ posX;
}