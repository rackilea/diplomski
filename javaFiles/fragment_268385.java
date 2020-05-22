AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("911 Info");
            alert.setMessage("Button Description: \n1. Calls 911\n2. Sends GPS Cordinates to Contact\n3. Activates a monitored call\n4. Activates alarm and captures images to web for viewing");
            alert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub
                        }
                    });
            alert.create();
            alert.show();