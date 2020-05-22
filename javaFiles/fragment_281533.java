holder.txtFullName.setText(searchResult.getString ("FirstName") + searchResult.getString ("LastName"));
    holder.txtBarcodeKeyword.setText(searchResult.getString("Barcode"));

    JsonObject ScanInfo = null;
    try {
        ScanInfo = searchResult.getObject("ScanInfo");
    } catch (JsonException e) {
        e.printStackTrace();
    }
    String LastScanTime[] = ScanInfo.getString("LastScanTime").split(" "); // May be here its not getting values and unable to split the content

    holder.txtDateScan.setText(LastScanTime[0]); // if thats false may be LastScanTime is null
    try {
        if(ScanInfo.getInt("Scans") == 0 || StringUtils.isNullOrEmpty(ScanInfo.getString("Scans")))
            holder.imgScanStatus.setImageResource(R.drawable.red);
        else if(ScanInfo.getInt("Scans") % 2 == 0)
            holder.imgScanStatus.setImageResource(R.drawable.orange);
        else if(ScanInfo.getInt("Scans") % 2 == 1)
            holder.imgScanStatus.setImageResource(R.drawable.green);
    } catch (JsonException e) {
        e.printStackTrace();
    }

    holder.txtHourScan.setText(LastScanTime[1]);