public static void main(String[] args)
{
    try
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<256;++i)
        {
            String encoded = URLEncoder.encode(String.valueOf((char) i), "UTF-8");
            if(!encoded.startsWith("%") && !encoded.matches("^[a-zA-Z0-9]+$"))
            {
                sb.append(' ').append(encoded);
            }
        }
        System.out.println(sb.substring(1));
    }
    catch(Exception e){}
}