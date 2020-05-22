private Color multiply(Color color1, Color color2)
{
    float[] color1Components = color1.getRGBComponents(null);   
    float[] color2Components = color2.getRGBColorComponents(null);
    float[] newComponents = new float[3]; 

    for(int i = 0; i < 3; i++)
        newComponents[i] = color1Components[i] * color2Components[i];

    return new Color(newComponents[0], newComponents[1], newComponents[2],
        color1Components[3]);
}