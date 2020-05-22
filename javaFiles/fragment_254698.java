private LoaderManager.LoaderCallbacks<Cursor> loaderCallbacks = new LoaderManager.LoaderCallbacks<Cursor>() {
        @Override
        public Loader<Cursor> onCreateLoader(int id, Bundle args) {

            switch (id) {
                case CONTACTS_LOADER_ID:

                    return new CursorLoader(
                            getActivity(),
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            PROJECTION,
                            null,
                            null,
                            ContactsContract.Contacts.DISPLAY_NAME_PRIMARY + " ASC"
                    );
                default:
                    return null;
            }
        }

        @Override
        public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
            switch (loader.getId()) {
                case CONTACTS_LOADER_ID:

                   //Use ContactUtils class here


                    break;
            }
        }

        @Override
        public void onLoaderReset(Loader<Cursor> loader) {

        }
    };