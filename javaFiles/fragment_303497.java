public void onActivityResult(int requestCode, int resultCode, Intent intent) 
{

        if (requestCode == SCANNER_REQUEST_CODE) {
            // Handle scan intent
            if (resultCode == Activity.RESULT_OK) {

                Intent intent = ControllerIntentBuilder.create(this, requestCode, resultCode, intent);
                startActivity(intent);;

            } else if (resultCode == Activity.RESULT_CANCELED) {
                // Handle cancel
            }
        } else {
            // Handle other intents
        }
}