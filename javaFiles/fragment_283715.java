....

    @Override
    public void afterTextChanged(Editable editable) {
        if (editable.length() != 0) {
            setData(editable.toString());
        }
    }

....

private void setData(String searchString) {
AndroidNetworking.post("http://akhbaresteghlal.ir/search/getInformations.php")
  .addBodyParameter("word", searchString)
  .build()
....