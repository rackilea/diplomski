class InvMaintenance {

    final static long MAX_SIZE = 100;          //constant for array length

    public static void main(String[] args)
    {
        //Output options
            /*  Inventory Maintenance
                1) Add Item
                2) Remove Item
                3) Sell Item
                4) Receive Item
                5) Display Inventory
                6) Quit
                Please Select NUMBER: */

        //switch on options
        //call appropriate method

        //create an OutputStream to write data to a file
        FileOutputStream fos = new FileOutputStream(inven.dat);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        Inventory cInventory = new Inventory(MAX_SIZE); //instantiate Inventory object

        oos.writeObject(cInventory);
        oos.close();
    }   

}