/** accepts all int arrays from one to 255 dimensions */
public static TreeMap<IntBuffer,Integer> toMap(Object array) {
    int dim=1;
    for(Class<?> cl=array.getClass(); ; cl=cl.getComponentType())
        if(Object[].class.isAssignableFrom(cl)) dim++;
        else if(cl==int[].class) break;
        else throw new IllegalArgumentException(array.getClass().getSimpleName());
    TreeMap<IntBuffer,Integer> map=new TreeMap<>();
    fill(map, new int[dim], 0, array);
    return map;
}

private static void fill(TreeMap<IntBuffer, Integer> map, int[] i, int ix, Object array) {
    int next=ix+1;
    i[ix]=0;
    if(next<i.length)
        for(Object part: (Object[])array) {
            if(part!=null) fill(map, i, next, part);
            i[ix]++;
        }
    else
        for(int val: (int[])array) {
            if(val!=0) map.put(IntBuffer.wrap(i.clone()), val);
            i[ix]++;
        }
}