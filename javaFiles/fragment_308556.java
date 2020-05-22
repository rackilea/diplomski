Button buttonSend;
int phone =9900990;

public void onClick(View v) {  

    switch (v.getId()) {     

        case R.id.buttonSend:     
             String messageToSend = "#abc";
             String number = " " + phone;

             SmsManager.getDefault().sendTextMessage(number, null, messageToSend, null,null);
             break;
    }
}