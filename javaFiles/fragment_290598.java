public class YourClass
{


long startTs;

// your other code goes here..

        mbtnLogFileAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (action) {
                    case "Record":
                        Log.i(TAG, CSubTag.bullet("ATRx.onPreExecute", "start Recording logs"));

                        mbtnLogFileAction.setText("Pause");
                        metLogFileName.setEnabled(false);

                        String logFileName = metLogFileName.getText().toString();

                        if (logFileName != null && !logFileName.isEmpty()) {

                            if (!mLogFileHT.containsKey(logFileName)) {
                                startTs = TimeUtils.getTSSec();//cant assign value to final variable
                                mLogFileHT.put(logFileName, startTs);
                            } else {
                                startTs = mLogFileHT.get(logFileName);//cant assign value to final variable
                            }

}