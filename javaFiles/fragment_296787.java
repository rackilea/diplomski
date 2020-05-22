val data =  Intent();
    val text = "Result to be returned...."
//---set the data to pass back---
    data.setData("Your Data");
    setResult(RESULT_OK, data);
//---close the activity---
    finish()