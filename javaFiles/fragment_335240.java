/**
 * Responsible for drawing orthogonal edges between two nodes.
 */
public class OrthogonalEdgeRenderer
  extends EdgeRenderer {
  /**
   * Creates a new edge renderer with a given arrowType. The edgeType is
   * ignored -- the edges are drawn orthogonally, as per the responsibility
   * of this class. The arrowType is one of the Constants.EDGE_ARROW_* values.
   *
   * @param edgeType Ignored.
   * @param arrowType One of Constants.EDGE_ARROW_*.
   * @see prefuse.Constants
   */
  public OrthogonalEdgeRenderer( int edgeType, int arrowType ) {
    super( edgeType, arrowType );
  }

  /**
   * Creates a new instance with no arrow head.
   */
  public OrthogonalEdgeRenderer() {
    this( Constants.EDGE_TYPE_LINE, Constants.EDGE_ARROW_NONE );
  }

  /**
   * Creates an orthogonal shape (an edge) to draw between two nodes.
   *
   * @param vi The visual item with start and end points.
   * @return The shape to draw between the nodes for this edge.
   */
  protected Shape getRawShape( VisualItem vi ) {
    Path2D.Double result = new Path2D.Double();

    if( vi instanceof EdgeItem ) {
      EdgeItem ei = ( EdgeItem )vi;

      double sx = ei.getSourceItem().getX();
      double sy = ei.getSourceItem().getY();
      double tx = ei.getTargetItem().getX();
      double ty = ei.getTargetItem().getY();

      double midy = ( sy + ty ) / 2;

      if( midy != sy && midy != ty ) {
        result.moveTo( sx, sy );
        result.lineTo( sx, midy );
        result.lineTo( tx, midy );
        result.lineTo( tx, ty );
      }
    }

    return result;
  }
}