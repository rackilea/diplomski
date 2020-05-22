do {
   AddressInfo mAddress = new AddressInfo();
   mAddress.setSrNO(mCursor.getString(mCursor
           .getColumnIndex("SrNo")));
   mAddress.setAddress(mCursor.getString(mCursor
            .getColumnIndex("Address1")));
   mAddress.setTotalMale(mCursor.getString(mCursor
            .getColumnIndex("TotalMale")));
   mAddress.setTotalFemal(mCursor.getString(mCursor
            .getColumnIndex("TotalFemale")));
   mAddress.setTotalVoter(mCursor.getString(mCursor
            .getColumnIndex("TotalVoters")));    

   // Add AddressInfo obejct ot ArrayList!
   mAddressArray.add(mAddress);

} while (mCursor.moveToNext());