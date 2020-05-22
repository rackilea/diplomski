public class EncapsulatedData {
    private final byte[] data; //<-- only holds a reference to the byte array, no data is copied
    private final int start;
    private final int range;

    public EncapsulatedData(byte[] data, int start, int end){
        this.data=data;
        this.start=start;
        this.range=end-start;

        if (end>=data.length || start<0){
            throw new IndexOutOfBoundsException();
        }
    }

    public byte get(int index){
        if (index>range){
            throw new IndexOutOfBoundsException();
        }
        return data[index+start];
    }

    public static void main(String[] args){
        byte[] bigData=new byte[]{0,1,2,3,4,5,6,7,8,9,10};

        EncapsulatedData dataProvider=new EncapsulatedData(bigData,4,9);

        System.out.println(dataProvider.get(0)); //prints 4
        System.out.println(dataProvider.get(2)); //prints 6
        System.out.println(dataProvider.get(4)); //prints 8
        System.out.println(dataProvider.get(5)); //prints 9
    }


}