public class TheSpecialListener implements
            DatePickerDialog.OnDateSetListener {

        private int id;

        public TheSpecialListener(int id) {
            this.id = id;
        }

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                int dayOfMonth) {
            mTempYear = year;
            mTempMonth = monthOfYear;
            mTempDay = dayOfMonth;
            // id is the QuestionID so you now can identify the Button that started the dialog
        }

    };