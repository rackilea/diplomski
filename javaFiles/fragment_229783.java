private class CustomListAdapter extends ArrayAdapter<CustomModel> {

    // you adapter code here...

    public void updateList(List<CustomModel> list) {

        this.list = list;
        notifyDataSetChanged();

    }