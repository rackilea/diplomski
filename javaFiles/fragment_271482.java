Thread mythread = new Thread(runnable);
            mythread.start();

            while(mythread.isAlive()){
                //wait till thread finishes
            }

            textinfo += Global.classtext;
            textinfo += "Finished.\n";
            tv.setText(textinfo);

            return true;