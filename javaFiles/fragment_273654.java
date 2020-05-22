EncapsulatedData(EncapsulatedData encapsulateData, int start, int end){
    this.data=encapsulateData.data;
    this.start=encapsulateData.start+start;
    this.range=end-start;

    if (end>encapsulateData.range || start<0){
        throw new IndexOutOfBoundsException();
    }
}
....
....
....
public static void main(String[] args){
    byte[] bigData=new byte[]{0,1,2,3,4,5,6,7,8,9,10};

    EncapsulatedData dataProvider=new EncapsulatedData(bigData,4,9);

    EncapsulatedData dataProvider2=new EncapsulatedData(dataProvider,1,3);

    System.out.println(dataProvider2.get(0)); //prints 5

}