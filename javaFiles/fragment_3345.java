if(BMI<18.5){
        for(i=0;i<=8;i++) {
            Button btn = new Button(this);
            LinearLayout.LayoutParams P = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            P.weight = 1;
            btn.setTag(i);
            btn.setLayoutParams(P);
            btn.setText(ActivityTextMen[i]);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Class clas = null;
                    try{
                        clas = Class.forName("plkk.developers.com.livfit."+ActivityIdMen[Integer.parseInt(""+btn.getTag())]);
                    }catch (ClassNotFoundException c){
                        c.printStackTrace();
                    }
                    if (clas!=null) {
                        Intent intent = new Intent(view.getContext(), clas);
                        startActivity(intent);
                    }
                }
            });
            ll.addView(btn);
        }