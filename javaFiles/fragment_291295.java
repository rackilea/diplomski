package com.test.client;

import java.util.Arrays;

import com.google.gwt.ajaxloader.client.AjaxLoader;
import com.google.gwt.ajaxloader.client.AjaxLoader.AjaxLoaderOptions;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.maps.gwt.client.GoogleMap;
import com.google.maps.gwt.client.InfoWindow;
import com.google.maps.gwt.client.InfoWindowOptions;
import com.google.maps.gwt.client.LatLng;
import com.google.maps.gwt.client.MapOptions;
import com.google.maps.gwt.client.MapTypeId;

public class GwtTest implements EntryPoint {

    @Override
    public void onModuleLoad() {
        AjaxLoaderOptions options = AjaxLoaderOptions.newInstance();
        options.setOtherParms("sensor=false");
        Runnable callback = new Runnable() {
            public void run() {
                createMap();
            }
        };
        AjaxLoader.loadApi("maps", "3", callback, options);

        //this works
        CellTable dg = createTable();
        RootPanel.get("tableDiv").add(new ScrollPanel(dg));
    }

    public void createMap() {

        MapOptions mapOpts = MapOptions.create();
        mapOpts.setZoom(4);
        mapOpts.setCenter(LatLng.create(37.09024, -95.712891));
        mapOpts.setMapTypeId(MapTypeId.TERRAIN);
        mapOpts.setStreetViewControl(false);

        GoogleMap map = GoogleMap.create(Document.get().getElementById("map_canvas"), mapOpts);

        CellTable dg = createTable();


        InfoWindowOptions iwo = InfoWindowOptions.create();
        iwo.setPosition(LatLng.create(37.09024, -95.712891));
        iwo.setContent(dg.getElement());

        InfoWindow infoWindow = InfoWindow.create(iwo);
        infoWindow.open(map);

    }

    public CellTable createTable(){
        Column columnA = new Column(new TextCell()){

            @Override
            public Object getValue(Object object) {
                return "one";
            }

        };

        Column columnB = new Column(new TextCell()){

            @Override
            public Object getValue(Object object) {
                return "two";
            }

        };

        Column columnC = new Column(new TextCell()){

            @Override
            public Object getValue(Object object) {
                return "three";
            }

        };

        CellTable dataGrid = new CellTable();
        dataGrid.addColumn(columnA, "A");
        dataGrid.addColumn(columnB, "B");
        dataGrid.addColumn(columnC, "C");

        dataGrid.setRowCount(1);
        dataGrid.setRowData(Arrays.asList("one", "two", "three"));

        dataGrid.setWidth("200px");
        dataGrid.setHeight("100px");

        return dataGrid;
    }
}