static List<short[]> a = new ArrayList<>();
static void add( int... row ){
    short[] srow = new short[row.length];
    for(int i = 0; i < row.length; ++i ){ srow[i] = (short)row[i]; }
    a.add( srow );
}
static {
   add(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19);
   add(...)
}