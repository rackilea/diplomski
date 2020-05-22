recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapterActivity = new HistoryAdapter(arrayList);
        recyclerView.setAdapter(adapterActivity);
        backGroundWorkeroneSignup = new BackGroundWorkeroneSignup();
        backGroundWorkeroneSignup.execute(arrayList);