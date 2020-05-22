public class myListener implements OnClickListener() {
  private boolean ignoreClicks = false;

  public void setIgnoreClicks( boolean b ) { 
    this.ignoreClicks = b;
  }

  @Override
  public void onClick( View v ) {
    if ( !ignoreClicks ) {
      // use v to get the button, then change the color
      ignoreClicks = true;
      // start a new AsyncTask and give it the listener and the view
      // in doInBackground sleep for 2 seconds
      // in onPostExecute change the color of the button back to normal
      //     (you have a reference to the button because you gave the view to the AsyncTask)
      //   and set ignoreClicks to false in the listener
    }
  }
}