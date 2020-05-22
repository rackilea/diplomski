private void checkAndSet(Checkable checkable, String param) {

if (checkable.isChecked()) {
            // The toggle is enabled
            permSet.add(param);
            Log.e("ALERTDELETE", "CHECKED");
        } else {
            // The toggle is disabled
            permSet.remove(param);
            Log.e("ALERTDELETE", "UNCHECKED");
        }

}