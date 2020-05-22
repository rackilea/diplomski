ContentQueryMap mQueryMap = new ContentQueryMap(cursor, BaseColumns._ID, true, null);

            Comparator<Long> numberAmaxB = new Comparator<Long>() {
                @Override public int compare(Long s1, Long s2) {
                    if (s1<s2)
                        return 1;
                    else if (s1>s2)
                        return -1;
                    else
                        return 0;
                }           
            };
            SortedMap<Long, String> mySortedMap = new TreeMap<Long, String>(numberAmaxB);

            for (Map.Entry<String, ContentValues> row : mQueryMap.getRows().entrySet()) {

                Long _ID = Long.valueOf(row.getKey());
                String data= row.getValue().getAsString("data_column");
             conversationsSortedMap.put(_ID, data);
            }