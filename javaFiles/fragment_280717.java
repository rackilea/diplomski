class MySwingWorker extends SwingWorker <String,String>{ //what params you want here 

@Override
protected String doInBackground()throws Exception{

   //here you download heavy task
    //and you call publish() when you want 
}

@Override
protected void process(List<String> chunks){
  // here you updated your gui 
   //setValueAt(row,col); and fireTableCellUpdated(row,col);
}

@Override
protected void done(){
  //here is called when doInBackGround is finished
}