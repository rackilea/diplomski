logoutBtn.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v){
               MainActivity.mAuth.signOut();
               Intent i = new Intent(getActivity(),MainActivity.class);
               startActivity(i);
               getActivity().finish();
           }
        });