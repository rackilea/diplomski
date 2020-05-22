String FILE = Environment.getExternalStorageDirectory().getPath()+"/abc.pdf";   

 File file = new File(FILE); 

 //file should contain path of pdf file/
 Uri path = Uri.fromFile(file);
 Intent intent = new Intent(Intent.ACTION_VIEW);
 intent.setDataAndType(path, "application/pdf");
 intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

 try {
       startActivity(intent);
     } 
     catch (ActivityNotFoundException e)
     {
            Toast.makeText(this, 
                "No Application Available to View PDF", 
                Toast.LENGTH_SHORT).show();
        }