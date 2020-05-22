public class TestRequest implements Serializable {

        @SerializedName("mobileNumber")
        private String mobileNumber;

        public TestRequest(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }
        public String getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }
    }