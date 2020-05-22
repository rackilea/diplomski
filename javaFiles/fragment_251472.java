import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import org.junit.Test;
import java.util.Date;
import java.util.List;

public class CheckTest {

    @Test
    public void thisTest() {
        Gson gson = new GsonBuilder()
                .setDateFormat("dd-MM-yyyy")
                .setPrettyPrinting()
                .create();
        String message = "{\"Tickets\":" +
                "[{\"Type\":\"type1\"," +
                "\"Author\":\"author1\"," +
                "\"Rows\":[{\"Price\":\"100.0\"," +
                "\"Date\":\"24-06-2016\"," +
                "\"Amount\":\"10\"}," +
                "{\"Type\":\"Comment\"," +
                "\"Value\":\"some comment goes here\"}]," +
                "\"ID\":\"165\"}]," +
                "\"Desk\":\"desk1\"," +
                "\"User\":\"user1\"}";
        TicketWrapper ticket = gson.fromJson(message, TicketWrapper.class);
        System.out.println(ticket.toString());
    }

    public class TicketWrapper {
        @SerializedName("Tickets")
        private List<Ticket> tickets;
        @SerializedName("Desk")
        private String desk;
        @SerializedName("User")
        private String user;
        public TicketWrapper() {
        }
    }

    public class Ticket {
        @SerializedName("Type")
        private String type;
        @SerializedName("Author")
        private String author;
        @SerializedName("Rows")
        private List<Row> rows;
        @SerializedName("ID")
        private String id;

        public Ticket() {
        }
    }

    public class Row {
        @SerializedName("Type")
        private String type;
        @SerializedName("Value")
        private String value;
        @SerializedName("Price")
        private float price;
        @SerializedName("Date")
        private Date date;
        @SerializedName("Amount")
        private int amount;

        public Row() {
        }
    }
}