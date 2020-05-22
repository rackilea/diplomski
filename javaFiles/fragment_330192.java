public static void main(String[] args)
{
    MyObject myObj = new MyObject();
    myObj.name = "Name00";
    myObj.myObjectsList = new ArrayList<MyObject>();

    MyObject tmp1;
    MyObject tmp2;

    tmp1 = new MyObject();
    tmp1.name = "Name10";
    myObj.myObjectsList.add(tmp1);

    tmp1.myObjectsList = new ArrayList<MyObject>();
    tmp2 = new MyObject();
    tmp2.name = "Name20";
    tmp1.myObjectsList.add(tmp2);

    tmp2 = new MyObject();
    tmp2.name = "Name21";
    tmp1.myObjectsList.add(tmp2);

    tmp1 = new MyObject();
    tmp1.name = "Name11";
    myObj.myObjectsList.add(tmp1);

    tmp1 = new MyObject();
    tmp1.name = "Name12";
    myObj.myObjectsList.add(tmp1);

    myObj.print(0);
}