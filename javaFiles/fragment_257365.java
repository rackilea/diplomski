ListAdapter adapter = new SimpleAdapter(
                        MainActivity.this,
                        rssFeedList, R.layout.site_list_row,
                        new String[] { TAG_ID, TAG_TITLE, TAG_LINK },
                        new int[] { R.id.sqlite_id, R.id.title, R.id.link });

                lv.setAdapter(adapter);