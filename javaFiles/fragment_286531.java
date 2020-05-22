LayoutInflater inflater = getLayoutInflater();
  View view=inflater.inflate(R.layout.dlg_sector_add,null);
   new AlertDialog.Builder(ActSectors.this)
   .setTitle(R.string.menu_new_sector)
   .setMessage(R.string.dlg_sect_add_msg)
   .setView(view)
   //... your code here