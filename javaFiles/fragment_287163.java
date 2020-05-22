if (Storedata != null){
        editor.putStringSet("AddedItems", Storedata);
        editor.commit();
    } else {
        Set<String> cart = cartItems.getStringSet("AddedItems", null);
    }