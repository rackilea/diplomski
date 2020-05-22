final ArrayList<String> maindb = new ArrayList<>();
    maindb.add("@gmail.com");
    maindb.add("@rediffmail.com");
    maindb.add("@hotmail.com");
    maindb.add("@outlook.com");
    final ArrayList<String> compare = new ArrayList<>();
    final ArrayAdapter<String> adpt = new ArrayAdapter<String>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, compare);
    Word.setAdapter(adpt);
    Word.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.length() >= 0)
                if (!s.toString().contains("@")) {
                    compare.clear();
                    for (String aMaindb : maindb) {
                        aMaindb = s + aMaindb;
                        compare.add(aMaindb);
                    }
                    adpt.clear();
                    adpt.addAll(compare);
                }
        }
    });