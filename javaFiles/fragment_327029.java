recyclerView.setadapter(new BlaBlaAdapter(context, etc, new OnEditTextChangeNecessaryListener(){

    @Override
    onEditTextChangeNecessary(EditText editText){
            editText.setText("Something");
    }

    }));