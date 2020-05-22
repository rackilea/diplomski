public class FloatCS extends ColorSpace
{

private static final long serialVersionUID = -7713114653902159981L;

private ColorSpace rgb = ColorSpace.getInstance(ColorSpace.CS_sRGB) ;

public FloatCS(int type, int channel)
    {
    super(type, channel) ;
    }


@Override
public float[] fromCIEXYZ(float[] pixel)
    {
    return fromRGB(rgb.fromCIEXYZ(pixel)) ;
    }

@Override
public float[] fromRGB(float[] RGB)
    {   
    return RGB ;
    }

@Override
public float[] toCIEXYZ(float[] pixel)
    {
    return rgb.toCIEXYZ(toRGB(pixel)) ;
    }

@Override
public float[] toRGB(float[] nRGB)
    {
    return nRGB ;
    }
}