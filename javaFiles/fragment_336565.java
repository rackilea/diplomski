class Counter{
    private final int[] list;
    private count = 0;
    private final maxCount = 10;


    public Counter(int[] list){
       this.list = list;
    }

    public boolean updateValueAndCheckPastMax(int index, int value){
         list[index] = value;
         count += value;
         return count >= maxCount;
    }
}