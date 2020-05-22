Cursor userCur = adaptor.getYourData();
            if (userCur != null) {
                String[] strArr = new String[userCur.getCount()];
                startManagingCursor(userCur);
                if (userCur.moveToFirst()) {
                    int count = 0;
                    do {
                        String userName = userCur.getString(1);
                        strArr[count] = userName.trim();
                        count++;
                    } while (userCur.moveToNext());
                }

ArrayList<String> content = new ArrayList<String>();  
               for (int i=-1,l=from.length; ++i<l;) {    
                content.add(from[i]);              
      //Log.i("ArrayList", from[i]);           
     }                  
}