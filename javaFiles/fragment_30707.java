public Cursor getBarcodeInfo(String number){

    // Safe check to make sure db and number is not null
    if(db == null || number == null){

         return null;
    }

    return db.rawQuery("select _id, barcode_item_name, barcode_measurement, barcode_unit from barcode where barcode_number = ?", new String[]{number});
}