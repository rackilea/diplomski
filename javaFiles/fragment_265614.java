public class GetApi extends AsyncTask<Object, Object, Value[]> {
        private Button button;
        public GetApi(Button mButton){
            this.button = button;
        }
        private final String API_KEY = "xxxxxxxxxxxxxxxxxxxxxxxxxx";
        private final String SWITCHID = "xxxxxxxxxxxxxxxxxxxxxxxxx";

        @Override
        protected Value[] doInBackground(Object... params) {
            ApiClient apiClient = new ApiClient(API_KEY);
            Variable statusSwitch = apiClient.getVariable(SWITCHID);
            Value[] variableValues = statusSwitch.getValues();

            return variableValues;
        }
        @Override
        protected void onPostExecute(Value[] variableValues) {

            String status = Double.toString(variableValues[0].getValue());
            mSwitchStatus.setText(status);

            if(status.equals("1.0")){
                button.setVisibility(View.INVISIBLE);
            }

        }
    }