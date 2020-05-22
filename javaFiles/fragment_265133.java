@Override
  public Object instantiateItem(ViewGroup container, int position) {
       View viewItem = inflater.inflate(R.layout.pager_layout, container, false);
       ListView listView = (ListView) viewItem.findViewById(R.id.list);

}