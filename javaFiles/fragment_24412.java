private void typefaces(int... args){
    Typeface buttontypeface = Typeface.createFromAsset(getAssets(), "Calculator.ttf");
    for(int i = 0; i < args.length; i++){
        ((Button) findViewById(args[i])).setTypeface(buttontypeface);
    }
}