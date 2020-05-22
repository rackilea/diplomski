public double x;
public double y;
public double z;

public Vecteur (double x,double y,double z ) 
{

    this.x=x;
    this.y=y;
    this.z=z;
}


public void affichage ()
{  
    System.out.println("("+x+","+y+","+z);
}

public double norme() 
{   
    return Math.sqrt(x*x+y*y+z*z);
}

public static Vecteur somme(Vecteur v1, Vecteur v2) // he told us to make it static nom matter what 
{
     Vecteur u = new Vecteur(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
     return u;
}

public Vecteur somme(Vecteur other)
{
    Vecteur u = new Vecteur(this.x + other.x, this.y + other.y, this.z + other.z);
    return u;
}

public double produit(Vecteur v)
{
    return x*v.x+y*v.y+z*v.z; 
}