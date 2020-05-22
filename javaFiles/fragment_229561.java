if (hasPhoneNumber > 0) {
        mBuilder.append("\"").append(name).append("\"");
        Cursor cursor = mContentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "= ?",
                new String[]{id}, null);

        assert cursor != null;
        while (cursor.moveToNext()) {
            String phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                    .replaceAll("\\s", "");

            // if number is not existing in the list, then add number to the string
            if (!(mBuilder.toString().contains(phoneNumber))) {
                mBuilder.append(", ").append(phoneNumber);
            }
        }

        cursor.close();
    }