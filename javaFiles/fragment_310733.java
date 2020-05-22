String num = serverValue;

int limit = Integer.valueof(num);

selfList = new ArrayList<>();

for(int i=0; i<limit; i++)
{
    selfList.add("" + i);    // add "" with i if you want list with string type
}

// call your init method here
initViews();


// your init method
private void initViews(){
    RecyclerView recyclerView = 
    (RecyclerView)findViewById(R.id.recyclerviewSelfMachine);
    recyclerView.setHasFixedSize(true);
    RecyclerView.LayoutManager layoutManager = 
    new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(layoutManager);

    RecyclerView.Adapter adapter = new RecyclerViewSelf(selfList);
    recyclerView.setAdapter(adapter);
    }
}