import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "row")
public class Row {
  @JacksonXmlProperty(localName = "TradeID")
  private int tradeId;

  public int getTradeId() {
    return tradeId;
  }

  public void setTradeId(int tradeId) {
    this.tradeId = tradeId;
  }

  @Override
  public String toString() {
    return "Row [tradeId=" + tradeId + "]";
  }
}