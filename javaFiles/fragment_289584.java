class ExcludeZero
{
    public static void main (String[] args)
    {
        int array[]={-5,-4,-3,1,2,3,4,0,-1,-2,0,5,6,7,8,-9,-8,-7,-6};
        int rawPositiveArray[]=new int[array.length];
        int rawNegativeArray[]=new int[array.length];
        int insertPositivePosition=0;
        int insertNegativePosition=0;
        for(int i=0;i<array.length;i++){
            if(array[i]>0){
                rawPositiveArray[insertPositivePosition]=array[i];
                insertPositivePosition++;
            }else if(array[i]<0){
                rawNegativeArray[insertNegativePosition]=array[i];
                insertNegativePosition++;
            }
        }
        rawPositiveArray=trimArray(rawPositiveArray);
        rawNegativeArray=trimArray(rawNegativeArray);
    }

    private static int[] trimArray(int array[]) {
        // TODO Auto-generated method stub
        int targetIndex = 0;
        for( int sourceIndex = 0;  sourceIndex < array.length;  sourceIndex++ )
        {
            if( array[sourceIndex] != 0 )
                array[targetIndex++] = array[sourceIndex];
        }
        int[] newArray = new int[targetIndex];
        System.arraycopy( array, 0, newArray, 0, targetIndex );
        return newArray;
    }
}