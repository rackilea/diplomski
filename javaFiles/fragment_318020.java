private void showDialogDelete(final int idRecord) {
    final AlertDialog.Builder dialogDelete=new AlertDialog.Builder(TraineeListActivity.this);
    dialogDelete.setTitle("Warning!!");
    dialogDelete.setMessage("Are you sure to delete?");
   // final EditText idText=findViewById(R.id.idET);
    dialogDelete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                myDatabaseHelper.deleteData(idRecord);
                Toast.makeText(TraineeListActivity.this,"Deleted data",Toast.LENGTH_SHORT).show();


            }catch (Exception e){
                Log.e("error",e.getMessage());

            }

        }
    });
    dialogDelete.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    });
    dialogDelete.show();
}