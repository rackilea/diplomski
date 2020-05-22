/**
 * value = base * 10 ^ power.
 */

public class MyDouble {

    // Threshold values to determine whether given double is too small or not. 
private static final double SMALL_EPSILON = 1e-8;
private static final double SMALL_EPSILON_MULTIPLIER = 1e8;
private static final int    SMALL_EPSILON_POWER = 8;

private double myBase;
private int    myPower;

public MyDouble(double base, int power){
    myBase  = base;
    myPower = power;
}

public MyDouble(double base) 
{
    myBase  = base;
    myPower = 0;
    adjustPower();
}

/**
 * If base value is too small, increase the base by multiplying with some number and 
 * decrease the power accordingly. 
 * <p> E.g 0.000 000 000 001 * 10^1  => 0.0001 * 10^8  
 */
private void adjustPower()
{
    // Increase the base & decrease the power 
    // if given double value is less than threshold.
    if (myBase < SMALL_EPSILON) {
        myBase = myBase * SMALL_EPSILON_MULTIPLIER;
        myPower -= SMALL_EPSILON_POWER;
    }
}

/**
 * This method multiplies given double and updates this object.
 */
public void multiply(MyDouble d)
{
    myBase  *= d.myBase;
    myPower += d.myPower;
    adjustPower();
}

/**
 * This method multiplies given primitive double value with this object and update the 
 * base and power.
 */
public void multiply(double d)
{
    multiply(new MyDouble(d));
}

@Override
public String toString()
{
    return "Base:" + myBase + ", Power=" + myPower;
}

/**
 * This method multiplies given double values and returns MyDouble object.
 * It make sure that too small double values do not zero out the multiplication result. 
 */
public static MyDouble multiply(double...values) 
{
    MyDouble result = new MyDouble(1);
    for (int i=0; i<values.length; i++) {
        result.multiply(values[i]);
    }
    return result;
}

public static void main(String[] args) {
    MyDouble r = MyDouble.multiply(1e-80, 1e100);
    System.out.println(r);
}