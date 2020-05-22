public static String convertColorToHexadeimal(Color color)
{
        String hex = Integer.toHexString(color.getRGB() & 0xffffff);
        if(hex.length() < 6) 
        {
            if(hex.length()==5)
                hex = "0" + hex;
            if(hex.length()==4)
                hex = "00" + hex;
            if(hex.length()==3)
                hex = "000" + hex;
        }
        hex = "#" + hex;
        return hex;
}