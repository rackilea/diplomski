adapter = new SimpleAdapter(
                this, 
                arraylist, 
                android.R.layout.simple_list_item_1,
                new String[] { ITEM_KEY },
                new int[] { android.R.id.text1 });