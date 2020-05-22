ListView lv = (ListView)findViewById(R.id.list);
            List<Map<String,String>> mapList = new ArrayList<Map<String, String>>();
            Map<String,String> mapPerRow;
            for (int i = 0; i < rowNumbers; i++) {
                mapPerRow = new HashMap<String, String>();
                mapPerRow.put("column1", value1);
                mapPerRow.put("column2", value2);

                mapList.add(mapPerRow);
            }


            ListAdapter adapter = new SimpleAdapter(
                    MainActivitty.this,  mapList,
                    R.layout.list_item, new String[] { "column1", "colum2"},
                    new int[] { R.id.value1,R.id.value2 });
            // updating listview
            lv.setAdapter(adapter);