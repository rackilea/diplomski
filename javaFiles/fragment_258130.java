public static void main(String[] args)
{
    //final int it = 5;
    int size;
    size = 5;
    List<String> pad = new ArrayList<String>();
    pad.addAll(Arrays.asList("\t","\t","\t","\t","\t"));
    for( int i = 1;  i < size; ++i)
    {
        String star = "";
        //Pattern p = Pattern.compile("([)|(,)|(])");
        star += pad.toString().replaceAll("\\[|\\]|,", "");
        for (int j = 0; j < i; ++j)
        {
            star += "*\t\t";
        }
        pad.remove(pad.size()-1);
        System.out.println(star);

    }

}