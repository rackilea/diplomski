final int iCopy = i;
button.get(i).addListener(new ClickListener(){
    @Override 
    public void clicked(InputEvent event, float x, float y){
        Gdx.app.log( "test", "" + iCopy);
    }
});