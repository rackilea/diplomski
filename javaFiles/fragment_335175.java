fun keydown_onClick(){
        try{
            myActivity.setOnKeyListener { _, keyCode, event ->
                if (keyCode == android.view.KeyEvent.KEYS_YOU_CARE_ABOUT) {
                    //handle it
                    if(activeViewHolder != null){
                        var displayText = activeViewHolder.yourEditText.text
                        keyPressedChar = (char)event.getUnicodeChar()+""
                        //if it's a special key you care about, then handle it in a when statement or if and pass to your adapter if needed to go to next row for example.
                        displayText += keyPressedChar
                        activeViewHolder.yourEditText.text = displayText
                    }
                    return@setOnKeyListener true//we've processed it
                } else
                    return@setOnKeyListener false// pass on to be processed as normal
            }
        }catch (ex: Exception){
            A35Log.e(mClassTag, "Error handling onkeydown listener: ${ex.message}")
        }
    }