public class Title implements Serializable {
        String txn_date;
        Timestamp timestamp;
        String txn_type;
        String txn_rcvd_time;
        String txn_ref;
        String txn_status;
        public Title(String data){... //set values for fields with the data}
        // add all getters and setters for fields
    }

    Dataset<Title> resultdf = df.selectExpr("CAST(value AS STRING)").map(value -> new Title(value), Encoders.bean(Title.class))
resultdf.filter(title -> // apply any predicate on title)