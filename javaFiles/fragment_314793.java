public class SummaryResponse {

    public String id;
    public String bps_id;

    public Summary summary;
    public Message bps_message;
    public String bps_image;
    public Message error_message;
    public String error_flags;

    class Summary {
        public String as_of_date;
        public int bp_earned;
        public String bp_balance;
        public String bp_redeemed;
    }

    class Message {
        public String eng;
        public String chi;
    }
}