holder.someButton.setOnClickListener(new OnClickListener(){

    @Override
    void onClick(){
        necessaryListener.onEditTextChangeNecessary(holder.editText);
    }

});