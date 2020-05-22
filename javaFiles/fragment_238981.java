String[] Occupation = {"rest_all", "Government", "Officer", "Merchant", "Shipping", "Professor", "Teacher", "Doctor",
            "Dentist", "Chartered Accountant", "Cost Accountant", "Engineer", "Software", "Educationist", "Business",
            "Civil Services", "Management"};
    final List<String> list4 = Arrays.asList(getResources().getStringArray(R.array.Occupation));
    final List<KeyPairBoolData> listArray4 = new ArrayList<>();
    for (int i = 0; i < list4.size(); i++) {
        KeyPairBoolData h = new KeyPairBoolData();
        h.setId(Occupation[i]);
        h.setName(list4.get(i));
        h.setSelected(false);
        listArray4.add(h);

        occupationSpinner.setItems(listArray4, -1, new SpinnerListener() {
            @Override
            public void onItemsSelected(List<KeyPairBoolData> items) {
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).isSelected()) {
                        //     Log.i(getTag(), i + " : " + items.get(i).getName() + " : " + items.get(i).isSelected());
                        Log.e("spinner.........", items.get(i).getId() + " : " + items.get(i).isSelected());
                    }
                }
            }
        });
    }