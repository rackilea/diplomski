private JSONObject json = new JSONObject(...);//here if exists you should use default       constructor if not, you should find a way to put an argument to it.


    ...
       @Override
    protected Void doInBackground(Void... params) {
         .......

     bedrijfsnaam = json.getJSONObject("sCompanyName");
         .....
         }
    .....

        @Override
    public void onCreate(Bundle savedInstanceState){
         ....
        public void onClick(View v) {
        antwoord = bedrijfsNaam;
                btwuitvoer.setText(antwoord)
        ....
}