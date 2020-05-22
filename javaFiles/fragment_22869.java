public static void readPLUSalesData(String[] hexArray) {
    byte[] bytes = new byte[hexArray.length];
    for (int i = 0; i < bytes.length; ++i) {
         bytes[i] = Byte.parseByte(hexArray[i], 16);
    }

    ByteBuffer buf = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN;

    Transaction_PLUSale pluSale=new Transaction_PLUSale();
    pluSale.setOpcode(buf.get());

    byte[] arr[] = new byte[7];
    buf.get(arr);
    pluSale.setCode(arr);
    pluSale.setFlag1(buf.get());
    pluSale.setFlag2(buf.get());
    pluSale.setFlag3(buf.get());
    pluSale.setFlag4(buf.get());
    pluSale.setFlag5(buf.get());
    pluSale.setDeptnum(buf.getShort());
    pluSale.setMulti_sell_unit(buf.get());
    pluSale.setReturn_type(buf.get());
    pluSale.setTax_pointer(buf.get());
    pluSale.setQty(buf.getInt());
    pluSale.setPrice(buf.getInt());
    pluSale.setAmount(buf.getInt());
    pluSale.setNo_tax_price(buf.getInt());
    pluSale.setNo_tax_amount(buf.getInt());
    pluSale.setReturn_surcharge_percent(buf.getInt());
    pluSale.setProduct_code(buf.get());
    pluSale.setFlags(buf.get());
}