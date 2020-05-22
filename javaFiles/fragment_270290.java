final List <CheckBox> cbs = new ArrayList<CheckBox>();

            for(int i = 0; i < 5; i++){
                CheckBox cb = new CheckBox(this);
                cb.setText("Apple" + (i + 1));
                cbs.add(cb);
                ll3.addView(cbs.get(i));
            }