final CharSequence[] items = { "3 sec", "5 sec", "7 sec", "10 sec" }
                public void onClick(DialogInterface dialog, int item) {
                    Toast.makeText(getApplicationContext(), items[item],
                            Toast.LENGTH_SHORT).show();
                    if (items[item] == "3 sec") {
                        myChoice = 3000;
                    } else if (items[item] == "5 sec") {
                        myChoice = 5000;
                    } else if (items[item] == "7 sec") {
                        myChoice = 7000;
                    } else if (items[item] == "10 sec") {
                        myChoice = 10000;
                    }
                }