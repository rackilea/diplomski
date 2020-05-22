DataHolder holder;
    btn_editInfo.setOnClickListener(new View.OnClickListener(){
    public void onClick(View view){
        holder = DataHolder.getInstance(); //Getting DataHolder Instance
        holder.setName(CustName);
        holder.setIdNumber(IDNum);
        //set values for all fields using setters
        //holder.setSomething(something);

        //Start your first activity
        Intent confirmInsure = new Intent(/*activity_with_edit_btn*/.this, /*To_main_activity*/.class);
        startActivity(confirmInsure);
    }});