1. Pass context to your Task

MatchTableDataFeatching process = new MatchTableDataFeatching(this);

2. Get context in your Task

Context context;
public MatchTableDataFeatching(Context c) {
    context = c;
}
.......
3. Then in your onPost

@Override
protected void onPostExecute(Void aVoid) {
    super.onPostExecute(aVoid);
    ((TeamScoreTableUI)context).TextBox.setText(this.dataParsed);
    ((TeamScoreTableUI)context).CalladdRows();

}