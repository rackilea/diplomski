package com.test.multimap.client;

import com.google.gwt.ajaxloader.client.AjaxLoader;
import com.google.gwt.ajaxloader.client.AjaxLoader.AjaxLoaderOptions;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.maps.gwt.client.GoogleMap;
import com.google.maps.gwt.client.LatLng;
import com.google.maps.gwt.client.MapOptions;
import com.google.maps.gwt.client.MapTypeId;


public class GwtMultiMapTest implements EntryPoint {

    DockLayoutPanel parentPanel;

    SimpleLayoutPanel mapParent1 = new SimpleLayoutPanel();
    SimpleLayoutPanel mapParent2 = new SimpleLayoutPanel();
    SimpleLayoutPanel mapParent3 = new SimpleLayoutPanel();
    SimpleLayoutPanel mapParent4 = new SimpleLayoutPanel();
    GoogleMap map1;
    GoogleMap map2;
    GoogleMap map3;
    GoogleMap map4;

    public void onModuleLoad() {

        final DockLayoutPanel leftPanel = new DockLayoutPanel(Unit.PCT);
        leftPanel.addNorth(mapParent1, 50);
        leftPanel.add(mapParent2);

        final DockLayoutPanel rightPanel = new DockLayoutPanel(Unit.PCT);
        rightPanel.addNorth(mapParent3, 50);
        rightPanel.add(mapParent4);

        parentPanel = new DockLayoutPanel(Unit.PCT){
            public void onResize(){
                setWidgetSize(leftPanel, 50);
                leftPanel.setWidgetSize(mapParent1, 50);
                rightPanel.setWidgetSize(mapParent3, 50);
                super.onResize();
            }

        };
        parentPanel.addWest(leftPanel, 50);
        parentPanel.add(rightPanel);

        RootLayoutPanel.get().add(parentPanel);

        AjaxLoaderOptions options = AjaxLoaderOptions.newInstance();
        options.setOtherParms("sensor=false");
        Runnable callback = new Runnable() {
            public void run() {
                createMaps();
            }
        };
        AjaxLoader.loadApi("maps", "3", callback, options);
    }

    public void createMaps() {

        MapOptions mo1 = MapOptions.create();
        mo1.setZoom(4);
        mo1.setCenter(LatLng.create(37.09024, -95.712891));
        mo1.setMapTypeId(MapTypeId.TERRAIN);
        mo1.setStreetViewControl(false);
        map1 = GoogleMap.create(mapParent1.getElement(), mo1);

        MapOptions mo2 = MapOptions.create();
        mo2.setZoom(4);
        mo2.setCenter(LatLng.create(37.09024, -95.712891));
        mo2.setMapTypeId(MapTypeId.TERRAIN);
        mo2.setStreetViewControl(false);
        map2 = GoogleMap.create(mapParent2.getElement(), mo2);

        MapOptions mo3 = MapOptions.create();
        mo3.setZoom(4);
        mo3.setCenter(LatLng.create(37.09024, -95.712891));
        mo3.setMapTypeId(MapTypeId.TERRAIN);
        mo3.setStreetViewControl(false);
        map3 = GoogleMap.create(mapParent3.getElement(), mo3);

        MapOptions mo4 = MapOptions.create();
        mo4.setZoom(4);
        mo4.setCenter(LatLng.create(37.09024, -95.712891));
        mo4.setMapTypeId(MapTypeId.TERRAIN);
        mo4.setStreetViewControl(false);
        map4 = GoogleMap.create(mapParent4.getElement(), mo4);
    }
}