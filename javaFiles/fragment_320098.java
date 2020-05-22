public class YOUACTIVITY OR FRAGMENT extends ... implements LoadFilesTask.AsyncResponse, View.OnClickListener{

@Override
public void processFinish(String[][] types, String[][] moves, String[][] dex) {

    this.types =types;
    this.moves = moves;
    this.dex = dex;

    //Do whatever you want to do in Callback function
    Toast.makeText(context, "Read File Successfully!", Toast.LENGTH_LONG).show();
}