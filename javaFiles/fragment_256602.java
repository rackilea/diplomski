import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class PositionsDeserializer extends StdDeserializer<Positions> {

  public PositionsDeserializer() {
    super(Positions.class);
  }

  @Override
  public Positions deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
    Object[] positionsProps = p.readValueAs(Object[].class);
    if (positionsProps != null && positionsProps.length > 0) {
      String chanId = (String) positionsProps[0];
      List<Position> positionsList =
          ((List<List<?>>) positionsProps[1]).stream()
              .map(this::deserializePosition)
              .collect(Collectors.toList());
      Positions positions = new Positions();
      positions.setChannelId(chanId);
      positions.setPositions(positionsList);
      return positions;
    }
    // decide whether you want to return null, throw an exception or other outcome: depends on the constraints of your data
    return null;
  }

  private Position deserializePosition(List<?> props) {
    if (props != null && !props.isEmpty()) {
      final Position position = new Position();
      position.setSymbol((String) props.get(0));
      position.setStatus((String) props.get(1));
      position.setAmount((Double) props.get(2));
      position.setBasePrice((Double) props.get(3));
      position.setMarginFunding((Integer) props.get(4));
      position.setMarginFundingType((Double) props.get(5));
      position.setProfitLoss((Double) props.get(6));
      position.setProfitLossPercentage((Double) props.get(7));
      position.setLiquidationPrice((Double) props.get(8));
      position.setLeverage((Double) props.get(9));
      return position;
    }
    // decide whether you want to return null, throw an exception or other outcome: depends on the constraints of your data
    return null;
  }

}