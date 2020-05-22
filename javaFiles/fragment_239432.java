public void useArrayList()
{
    ArrayList<ArrayList<?>> weirdStructure = new ArrayList<ArrayList<?>>();
    ArrayList<String> x = new ArrayList<String>();
    ArrayList<String> y = new ArrayList<String>();
    ArrayList<String> z = new ArrayList<String>();          
    ArrayList<ArrayList<String>> xy = new ArrayList<ArrayList<String>>(); 
    xy.add(x);
    xy.add(y);
    weirdStructure.add(xy);     
    weirdStructure.add(z);

}