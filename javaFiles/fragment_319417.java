package org.jsc.core.visualization.jgraphx;

import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.util.mxPoint;
import com.mxgraph.view.mxGraph;

import java.util.Collections;
import java.util.List;

public class PtCompactTreeLayout extends mxCompactTreeLayout
{
    public PtCompactTreeLayout( mxGraph graph )
    {
        super( graph, false );
    }

    @Override
    public void setEdgePoints( Object edge, List<mxPoint> points )
    {
        if ( !( edge instanceof IfElseEdge ) )
        {
            super.setEdgePoints( edge, points );

            return;
        }
        IfElseEdge ifElseEdge = ( IfElseEdge ) edge;
        IfElseNodeVertex v = ( IfElseNodeVertex ) ifElseEdge.getSource();
        mxGeometry geo = v.getGeometry();
        mxGeometry vb = ifElseEdge.getGeometry();
        if ( vb == null )
        {
            super.setEdgePoints( edge, points );

            return;
        }

        double xc = geo.getCenterX();
        double yc = geo.getCenterY();
        double w = geo.getWidth();
        double h = geo.getHeight();
        double xt;

        double yt;
        int i = ( ifElseEdge == v.getEdge( 0 ) ? 0 : 1 );
        PtNodeVertex vs = v.getSuccessor( i );

        mxGeometry sgeo0 = v.getSuccessor( 0 ).getGeometry();
        mxGeometry sgeo1 = v.getSuccessor( 1 ).getGeometry();

        double ws0 = sgeo0.getWidth();

        xt = ( i == 0 ? sgeo0.getCenterX() : sgeo1.getCenterX());
        yt = ( i == 0 ? sgeo0.getY() : sgeo1.getY() );

        vb.setTargetPoint( new mxPoint( xt, yt ) );

        double xm = xt;

        mxPoint mp = new mxPoint( xm, yc );
        vb.setPoints( Collections.singletonList( mp ) );
        vb.setSourcePoint( calcSourcePoint( v, i ) );
    }

    private mxPoint calcSourcePoint( PtNodeVertex v, int i )
    {
        mxGeometry geom = v.getGeometry();

        double w = geom.getWidth();
        double xs = ( i == 0 ? geom.getX() : geom.getX() + geom.getWidth() );
        double ys = geom.getCenterY();

        return new mxPoint( xs, ys );
    }
}