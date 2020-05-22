chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox cb=(CheckBox) view;
                SportItem spI=getItem(pos);
                spI.setCheck(cb.isChecked());
            }
        });