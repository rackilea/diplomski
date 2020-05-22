b.setOnClickListener(new View.OnClickListener(){


        public void onClick(View v) {



                EditText hello = new EditText(MainActivity.this);

                hello.setText("enter value" + i++);
                linearLayout.addView(hello, layoutParams);

                hello.setId(i++);

               hello.setTag("edit");
        }

    });



int childcount = linearLayout.getChildCount();
    for (int i = 0; i < childcount; i++) {
             View v1 = linearLayout.getChildAt(i);
            if(v1.getTag.equls("edit"){

                    System.out.println(v1..getId());
             }

    }