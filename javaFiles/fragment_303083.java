import java.io.IOException;
import java.util.ArrayList;
import javax.json.stream.JsonParser;

public class JSONtry {

private static double[] parse1D(JsonParser parser) throws IOException {
    ArrayList<Double> l = new ArrayList<Double>();

    outerLoop:
        while (parser.hasNext()) {
           JsonParser.Event event = parser.next();
           switch(event) {
              case START_ARRAY: break;
              case END_ARRAY:
                  break outerLoop;
              case VALUE_STRING:
                  l.add(Double.parseDouble(parser.getString()));
                 break;
              default:
                  throw new IOException("Not a 1 dimensional array! Seeing: "+event.toString());
           }
        }
    double[] ret = new double[l.size()];
    for (int i = 0; i<l.size(); i++)
        ret[i] = l.get(i);
    return ret;
}
private static double[][] parse2D(JsonParser parser) throws IOException {
    ArrayList<double[]> l = new ArrayList<double[]>();

    outerLoop:
        while (parser.hasNext()) {
            JsonParser.Event event = parser.next();
            switch(event) {
            case START_ARRAY:
                l.add(parse1D(parser)); 
                break;
            case END_ARRAY:
                break outerLoop;
            default:
                throw new IOException("Not a 2 dimensional array! Seeing: "+event.toString());
            }
        }
    double[][] ret = new double[l.size()][l.get(0).length];
    for (int i = 0; i<l.size(); i++)
        ret[i] = l.get(i);
    return ret;
}
}