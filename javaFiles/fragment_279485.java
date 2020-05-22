}
        if (mySongs != null) {
            dialog.dismiss();
        }

        mySongs = fs.getsonglist();

        items = new String[mySongs.size()];
        for (int i = 0; i < mySongs.size(); i++) {
            items[i] = mySongs.get(i).getName().toString().replace(".3gp", "");