public boolean setViewValue(View view, Cursor cursor, int columnIndex) {        
        if (view.getId() == R.id.txtvwProfileUserFullName) {
            String userFullName = cursor.getString(columnIndex);
            ((TextView) view).setText(userFullName);
            return true;
        } else if (view.getId() == R.id.txtvwProfileOtherUserInfo) {
            String userEmail = cursor.getString(columnIndex);
            ((TextView) view).setText(userEmail);
            return true;
        } else {
            return false;
        }
}