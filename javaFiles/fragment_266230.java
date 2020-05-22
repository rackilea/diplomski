mAdapter = new SimpleCursorAdapter(this,
                R.layout.dropdown_text,
                null,
                new String[]{CITY_COUNTRY_NAME},
                new int[]{R.id.text},0);
        mAdapter.setFilterQueryProvider(new FilterQueryProvider() {
            @Override
            public Cursor runQuery(CharSequence constraint) {
                if (constraint != null) {
                    if (constraint.length() >= 3 && !TextUtils.isEmpty(constraint)) {
                        Bundle bundle = new Bundle();
                        String query = charArrayUpperCaser(constraint);
                        bundle.putString(CITY_ARGS, query);
                        getLoaderManager().restartLoader(0, bundle, MainActivity.this).forceLoad();
                    }
                }
                return null;
            }
        });