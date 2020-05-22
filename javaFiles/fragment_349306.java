for(View v: solo.getViews()) {
 if(v instanceof Button) {
    if( ((Button)v).getText().toString().equalsIgnoreCase("some text") )
{
            solo.clickOnView(v);
            solo.sleep(3000);
            break;
    }
 }

}