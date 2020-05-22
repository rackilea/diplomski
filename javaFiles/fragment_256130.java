package example;

import java.util.List;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.util.CsvContext;

public class OptionalIfOtherColumnEquals extends Optional {

  private final int column;

  private final Object constantValue;

  public OptionalIfOtherColumnEquals(int column, 
                                     Object constantValue) {
    super();
    this.column = column;
    this.constantValue = constantValue;
  }

  public OptionalIfOtherColumnEquals(int column, 
                                     Object constantValue, 
                                     CellProcessor next) {
    super(next);
    this.column = column;
    this.constantValue = constantValue;
  }

  @Override
  public Object execute(Object value, CsvContext context) {

    // unprocessed row
    List<Object> row = context.getRowSource();

    // optional if other column matches value
    if (row.get(column - 1).equals(constantValue)){
      return super.execute(value, context);
    }

    // otherwise continue to next processor
    return next.execute(value, context);
  }

}