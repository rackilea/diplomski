private class TargettingOverlay extends OverlayView {

    protected Element div ;
    protected PanelWrapper panelWrapper;
    private TargettingEffect targetEffect;

    TargettingOverlay(){
        targetEffect = new TargettingEffect();
        targetEffect.setLinedDimension(10500);
        targetEffect.setLinesOffset(-5000);
    }

    void positionTarget(LatLng loc, boolean withoutLines){
        if (targetEffect == null )
            return;

        if (loc == null) {
            targetEffect.setElementsVisible(false);
            return;
        }
        targetEffect.setElementsVisible(true);


        Point p = null;
        Point sw = null;
        Point ne = null;
        LatLng locSW = (LatLng)this.getMap().getBounds().getSouthWest();
        LatLng locNE = (LatLng)this.getMap().getBounds().getNorthEast();

        //
        p = (Point)getProjection().fromLatLngToDivPixel(loc);
        sw = (Point)getProjection().fromLatLngToDivPixel(locSW);
        ne = (Point)getProjection().fromLatLngToDivPixel(locNE);



        targetEffect.setWithoutLinles(withoutLines);
        targetEffect.target((int)ne.getY(), (int)p.getY(), (int)sw.getX(), (int)p.getX());
    }

    @Override
    public void draw() {
        Point ne = (Point)getProjection().fromLatLngToDivPixel((LatLng)
                this.getMap().getBounds().getNorthEast());
        Point sw = (Point)getProjection().fromLatLngToDivPixel((LatLng)
                this.getMap().getBounds().getSouthWest());


        div.getStyle().setTop(ne.getY(), Unit.PX);
        div.getStyle().setLeft(sw.getX(), Unit.PX); 
    }

    @Override
    public void onAdd() {
        div = DOM.createDiv();

        getPanes().getOverlayLayer().appendChild(div);

        panelWrapper = new PanelWrapper(div);
        panelWrapper.attach();          

        targetEffect.setContainer(panelWrapper);
    }

    @Override
    public void onRemove() {
        div.removeFromParent();
        panelWrapper.removeFromParent();

        div = null;
        panelWrapper = null;
    }

}