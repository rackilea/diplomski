String participentIDArray[] = participentID.split(",");
List<Friend> list = new ArrayList<Friend>();
for(int i = 0; i < participentIDArray.length; i++) {
    list.addAll(getDataFromDatabase(participentIDArray[i]));
}
madapter = new FriendListByGridAdapter(GroupinformationActivity.this, list);
groupdetailsdelist.setAdapter(madapter);
madapter.notifyDataSetChanged();