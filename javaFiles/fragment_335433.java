ArrayList<PayPalItem> stringArrayList = new ArrayList<PayPalItem>();

        for (int i = 0; i < 2; i++) {
            //create the PayPalItem and add to the list                  
            stringArrayList.add(new PayPalItem()); //add to arraylist
        }
        PayPalItem[] items = new PayPalItem[stringArrayList.size()];
        //if you want your array
        PayPalItem[] stringArray = stringArrayList.toArray(items);