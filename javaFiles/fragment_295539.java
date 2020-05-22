//create an OutputStream to write data to a file
FileOutputStream fos = new FileOutputStream(inven.dat);
BufferedOutputStream bos = new BufferedOutputStream(fos);
ObjectOutputStream oos = new ObjectOutputStream(bos);

Inventory cInventory = new Inventory(MAX_SIZE); //instantiate Inventory object