public static void main(String[] args) {

    List<Float> floatList=new ArrayList<Float>();
    int i=0;

    floatList.add(-221.5f);
    floatList.add(-221.6f);
    floatList.add(-221.7f);
    floatList.add(-221.8f);
    floatList.add(-221.9f);
    floatList.add(-221.1f);
    for (Float float1 : floatList) {
        i++;
        System.out.print(" "+float1+",");
        if(i%3==0){
            System.out.println();
        }

    }