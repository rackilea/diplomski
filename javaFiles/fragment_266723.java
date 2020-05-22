for( int i = 0; i < 4; i++)
{
    final int index = i; // <-- copy i to `index' to use in FieldChangeListener

    // ...

    celebbutton.setChangeListener(new FieldChangeListener() {

        public void fieldChanged(Field field, int context) 
        {
            UiApplication.getUiApplication().pushScreen(
               new FetchTweets(fusernamearray[index])); // <-- `index'
        }
    });


    femaleSec.add(celebbutton);
}