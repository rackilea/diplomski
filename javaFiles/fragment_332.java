ArrayList<HashMap<String, String>> mapArrayList= new ArrayList<>();
MyFragment mFrag = new MyFragment();
Bundle args = new Bundle();
args.putSerializable("LIST", (Serializable) mapArrayList);
mFrag.setArguments(args);
getSupportFragmentManager().beginTransaction().replace(container_id, mFrag).commit();