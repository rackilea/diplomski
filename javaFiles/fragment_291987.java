Network n = new Network( this, "nety", SHAPE_DRAW_2D3D, 0, true, true );
n.add(endConveyorPoint);
for(int i=0;i<5;i++){
    Source s = add_source();
    PointNode pn=new PointNode(this, SHAPE_DRAW_2D3D, true, 100.0,300.0+i*50, 0.0, 1.0, dodgerBlue );
    MarkupSegmentLine ms1 = new MarkupSegmentLine(  100.0, 300.0+i*50, 0.0, 350.0, 300.0+i*50, 0.0 );
    MarkupSegmentLine ms2 = new MarkupSegmentLine(  350.0, 300.0+i*50, 0.0, endConveyorPoint.getX(),endConveyorPoint.getY(), 0.0 );
    Path path = new Path( this, SHAPE_DRAW_2D3D, true, true, 
                                PATH_DASHEDLINE, dodgerBlue, 2.0, pn, endConveyorPoint, ms1, ms2 );
    presentation.add(pn);
    presentation.add(path);
    s.set_locationType(s.LOCATION_NODE);
    s.setLocation(pn);

    initialPoints.add(pn);
    n.add(pn);
    n.add(path);
}
n.initialize();