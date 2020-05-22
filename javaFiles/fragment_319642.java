@Override
    protected void onStart() {
        super.onStart();

        //create a new note fragment if one has not been created yet
        mNoteFragment = (NoteFragment) getFragmentManager().findFragmentById(R.id.container);
        if (mNoteFragment == null) {
            mNoteFragment = new NoteFragment();
            getFragmentManager().beginTransaction().replace(R.id.container, mNoteFragment).commit();
            getFragmentManager().executePendingTransactions();
        }

        //restore SharedPreferences
        SharedPreferences sharedPrefs = getPreferences(0);
        int stylePref = sharedPrefs.getInt(SharedPreferanceConstants.PREF_FONT_SIZE, 2);
        String fontPref = sharedPrefs.getString(SharedPreferanceConstants.PREF_TYPEFACE, "");
        Log.d("STYLEID", String.valueOf(stylePref));
        Log.d("FONTTYPE", fontPref);
        onStyleChange(null , stylePref);
        onFontChange(null, fontPref);
    }