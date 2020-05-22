@Override
    protected void onPostExecute(Cursor mCursor) {
        super.onPostExecute(mCursor);

        if(mCursor.moveToFirst()){ // перемещение к первому элементу

            // получение индекса столбца для каждого элемента данных

            int nameIndex = mCursor.getColumnIndex(COLUMN_NAME);
            int phoneIndex = mCursor.getColumnIndex(COLUMN_PHONE);
            int birthdayIndex = mCursor.getColumnIndex(COLUMN_BIRTHDAY);
            int passportIndex = mCursor.getColumnIndex(COLUMN_PASSPORT_SN);
            int adressIndex = mCursor.getColumnIndex(COLUMN_ADRESS);
            int siteIndex = mCursor.getColumnIndex(COLUMN_SITE);

            // заполнение компонентов TextViews выбранными данными
            nameTV.setText(mCursor.getString(nameIndex));
            phoneTV.setText(mCursor.getString(phoneIndex));
            birthdayTV.setText(mCursor.getString(birthdayIndex));
            passportTV.setText(mCursor.getString(passportIndex));
            adressTV.setText(mCursor.getString(adressIndex));
            siteTV.setText(mCursor.getString(siteIndex));
        }

        mCursor.close(); // закрытие курсора результата
        sdb.close(); // закрытие подключения к базе данных

    }