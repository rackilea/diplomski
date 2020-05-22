private void setupViews() {
        recyclerView=findViewById(R.id.rv_compareSearch_searchedProduct);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchItemAdapter=new SearchItemAdapter();

        // Here is the adapter
        recyclerView.setAdapter(searchItemAdapter);

        imgClose=findViewById(R.id.img_compareSearch_close);
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        edtSearch=findViewById(R.id.edt_compareSearch_serach);
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                viewModel.getSearchedProduct(String.valueOf(s))
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new SingleObserver<List<Product>>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                compositeDisposable.add(d);
                            }

                            @Override
                            public void onSuccess(List<Product> products) {
                                progressBar.setVisibility(View.GONE);
                                searchItemAdapter.onbind(products);
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.i("LOG", "onError: "+e.toString());
                            }
                        });
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        progressBar=findViewById(R.id.progress_compareSearch);
    }
}