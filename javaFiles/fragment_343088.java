InputStream in = new FileInputStream("/path/to/file.csv", "UTF-8");

//this skips UTF-8 BOM bytes, adjust to discard the bytes of whatever you have:

if(in.read() == 239 & in.read() == 187 & in.read() == 191){
    System.out.println("UTF-8 with BOM, bytes discarded");
}

//parse the InputStream now as the BOM bytes have been skipped.