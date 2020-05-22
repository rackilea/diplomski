onListItemClick(...., int position...){
    Intent i;
    switch(position){
    case 0:
        //SystemActivity
        i = new Intent(Menu.this, SystemActivity.class);
        break;
    //other cases
    }
    startActivity(i);
}