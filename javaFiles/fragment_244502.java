if (new ConnectionDetector(this).isConnectingToInternet()){
         Toast.makeText(context, "Wifi Conected", Toast.LENGTH_LONG).show();
        }
        else {

            Toast.makeText(context, "Wifi disconnected", Toast.LENGTH_LONG).show();
        }