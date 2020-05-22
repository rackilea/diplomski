RxSearchView.queryTextChanges(searchView)
            .debounce(600, TimeUnit.MILLISECONDS)
            .filter(charSequence -> !TextUtils.isEmpty(charSequence))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(query -> {
                Toast.makeText(this, query, Toast.LENGTH_SHORT).show();
            });