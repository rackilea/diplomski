...
..
.
@Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        updateTextCallback.updateText(s);
    }
...
..
.




public class horizontalAdapter extends RecyclerView.Adapter<horizontalHolder> {

  private ArrayList<optionModel> ListOf;
  public int temp;
  private UpdateTextCallback  updateTextCallback ;
  horizontalAdapter(ArrayList<optionModel> listOf, UpdateTextCallback  updateTextCallback) {
    ListOf = listOf;
    this.updateTextCallback = updateTextCallback;
  }
  ...
  ..
  .
}