....

    @Override
    public void afterTextChanged(Editable editable) {
        if (editable.length() != 0) {
            edt_search.removeTextChangedListener(this);
            setData();
            edt_search.addTextChangedListener(this);
        }
    }

....

private void setData() {
    AndroidNetworking.post("http://akhbaresteghlal.ir/search/getInformations.php")
      .addBodyParameter("word", edt_search.getText().toString())
      .build()
    ....