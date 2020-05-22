ListView.LayoutParams lp = new ListView.LayoutParams(ListView.LayoutParams.WRAP_CONTENT, ListView.LayoutParams.WRAP_CONTENT);        

    View footer = new View(listView1.getContext()); 

    footer = ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.on_tv_fragment_empty, null);        
    footer.setLayoutParams(lp);     

    OnTvFragment frag = new OnTvFragment();
    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();        
    ft.replace(R.id.ll, frag).commit();       
    getSupportFragmentManager().executePendingTransactions();

    listView1.addFooterView(footer);
    listView1.setAdapter(adapter);