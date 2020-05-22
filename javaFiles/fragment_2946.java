String[] names = {"frag_first", "frag_second", "frag_third"};

for (String name : names) {
   myFragment frag = new myFragment();
   getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, frag).commit();
   frag.setName = name;
}