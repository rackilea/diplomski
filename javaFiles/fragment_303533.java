void srcAgency(View v){ 
//We only want to start the AsyncTask here, nothing else.
// Whatever you did before and whatever triggered the srcAgency(View) method
srcAgency srcagen = new srcAgency();
srcagen.execute();
return;
}



public void realSrcAgency(View v) {
... // The rest of original srcAgency(View)
}

// Inside of asyncTask srcAgency ... 
public void postExecute() {
   // Call the new method we just had, but after our asyncTask is done.
  realSrcAgency(null);
}