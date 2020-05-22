PythonRunner.onPyUnitServerCreated.registerListener(new ICallbackListener<IPyUnitServer>() {

@Override
public Object call(IPyUnitServer obj) {
    obj.registerOnNotifyTest(new IPyUnitServerListener() {

        @Override
        public void notifyTestsCollected(String totalTestsCount) {
        }

        @Override
        public void notifyTest(String status, String location, String test, String capturedOutput, String errorContents,
                String time) {
        }

        @Override
        public void notifyStartTest(String location, String test) {
        }

        @Override
        public void notifyFinished(String totalTimeInSecs) {
        }

        @Override
        public void notifyDispose() {
        }
    });
    return null;
}