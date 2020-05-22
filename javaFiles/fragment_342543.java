public void create(MenuItem v) {
        newContact = new LinearLayout(this);
        newContact.setOrientation(LinearLayout.HORIZONTAL);


        LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = vi.inflate(R.layout.newcontact, null);
        Button b = (Button)view.findViewById(R.id.decl);
        if (b != null) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button b = (Button)v;
                    if ("D".equals(b.getText().toString())) {
                        b.setText("O");
                    } else {
                        b.setText(("D"));
                    }
                }
            });
        }
        view.setOnTouchListener(new OnSwipeTouchListener(this) {
            public void onSwipeRight() {
            }
        });

        // insert into main view
        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.insert);
        insertPoint.addView(view);
    }