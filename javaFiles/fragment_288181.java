@Override
     public void onClick(View view){

        if(view.getId() == R.id.textView1){
            Toast.makeText(view.getContext(),"Hi First", Toast.LENGTH_SHORT).show();
        }

        else if(view.getId() == R.id.textView2){
            Toast.makeText(view.getContext(),"Hi Second", Toast.LENGTH_SHORT).show();
        }
    }