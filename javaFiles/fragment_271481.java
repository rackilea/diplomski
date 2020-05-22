Thread mythread = new Thread(runnable);
        mythread.start();

        textinfo += Global.classtext;
        textinfo += "Finished.\n";
        tv.setText(textinfo);

        return true;