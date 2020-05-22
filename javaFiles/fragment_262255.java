authSuccessful = mfc.authenticateSectorWithKeyA(sector, key);

if(authSuccessful){
    // Read the block
    creditBlock = mfc.readBlock(block);

    String bytesString = Arrays.toString(creditBlock);
    Log.i(TAG, bytesString);

} else {
    Log.e(TAG, "Auth Failed");
}