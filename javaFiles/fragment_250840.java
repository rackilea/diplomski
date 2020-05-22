public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tv = (TextView) view.findViewById(R.id.textView);
        Bean bean = Adapter.getItem(position);
        bean.visibility = View.GONE
        tv.setVisibility(View.GONE);
        adapter.notifyDataSetChanged();
    }