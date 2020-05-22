listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(mTwoPane){
                    setItemNormal();
                    View rowView = view;
                    setItemSelected(rowView);
                    Fragment newFragment;
                    switch (position){
                         case 0:
                            newFragment = new FragmentWCBank ();
                            break;
                         case 1:
                            newFragment = new FragmentWCWAT();
                            break;
                         default:
                            newFragment = new FragmentWCBank ();
                            break;
                    }
                    WCLineActivity activity = (WCLineActivity) view.getContext();
                    FragmentTransaction transaction = activity .getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.detail_container, newFragment);
                    transaction.commit();
                }
                else{
                    Intent intent; 
                    switch (position){
                         case 0:
                            intent = new Intent(getActivity(), WCBankActivity.class);
                            break;
                         case 1:
                            intent = new Intent(getActivity(), WCWATActivity.class);
                            break;
                         default:
                            intent = new Intent(getActivity(), WCBankActivity.class);
                            break;
                    }
                    startActivity(intent);
                }
            }