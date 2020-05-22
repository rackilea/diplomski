addBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = (LayoutInflater) getBaseContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.row, null);
                Button buttonRemove = (Button) addView
                        .findViewById(R.id.remove);
                addView.setTag(tag);
                buttonRemove.setTag(tag);
                dynamicLayoutsTags.add(tag);
                Container.addView(addView);
                tag++;
                buttonRemove.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // ((LinearLayout) addView.getParent())
                        // .removeView(addView);
                        Integer removeTag = (Integer) v.getTag();
                        View deleteView = Container.findViewWithTag(removeTag);
                        Container.removeView(deleteView);
                        dynamicLayoutsTags.remove(removeTag);
                    }
                });

            }
        });