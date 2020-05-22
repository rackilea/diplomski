protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // Get the item that was clicked
        JSONObject o = (JSONObject) this.getListAdapter().getItem(position);
        adapter.getItem(position).toString();
        String link = o.getString("NameOfLinkInJsonObject");


        Toast.makeText(this, "You selected: " + link, Toast.LENGTH_LONG)
                .show();

        mMyWebView.loadUrl(link);
    }