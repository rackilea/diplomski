class Cone 
{
public double r;
public double h;

public void setRadius(double r)
{
    this.r = r;

}

public void setHeight(double h)
{
    this.h = h;

}

public double volume()
{
    double v;

    v = Math.PI * Math.pow(r,2) * (h/3);
    return v;
}

public double surfaceArea()
{
    double sa;

    sa = Math.PI* r * (r + Math.sqrt(Math.pow(h,2) + Math.pow(r,2)));

    return sa;
}