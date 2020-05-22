ArrayList<JSONObject> crumbsOut = new ArrayList<JSONObject>(count);

//.... pop the back stack to a certain point

//replace entire nav. backstack

for(int i = 0; i<count; i++)
{
  //move the transaction into the loop
  final FragmentTransaction transaction = this.getActivity().getSupportFragmentManager().beginTransaction();
  final JSONObject item = crumbsOut.get(i);
  final String id = item.getString("id");

  FolderFragment currentFolder = new FolderFragment();//fragment displays folder contents
  Bundle args = new Bundle();
  args.putString(DATA_ITEM_ID_KEY, id);
  args.putString(DATA_ITEM_NAME_KEY, item.getString("displayname"));
  currentFolder.setArguments(args);

  transaction.replace(R.id.MasterContainer, currentFolder);
  transaction.addToBackStack(id);

  // Commit the transaction
  //move the commit into the loop
  transaction.commit();
}