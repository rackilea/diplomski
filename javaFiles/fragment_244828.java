public void addView() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.item_task_list, null);
        ImageButton img_btn = view.findViewById(R.id.delete);
        EditText name_et = view.findViewById(R.id.todo);
        CheckBox done_cb = view.findViewById(R.id.done);
        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 // Do something
            }
        });
        parentLayout.addView(view, parentLayout.getChildCount() - 1);