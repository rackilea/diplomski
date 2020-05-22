package com.x.y.z;

import java.util.LinkedHashSet;
import java.util.Map;
import com.invient.vaadin.charts.InvientChartsConfig;
import com.x.y.Manager;
import com.x.y.util.ApplicationHelper;

public class SalesChat extends AbstractChart {

    private static final long serialVersionUID = -793793426045107314L;

    public SalesChat(InvientChartsConfig chartConfig) {
        super(chartConfig);
    }

    @Override
    public void build() {

        Manager manager = (Manager)ApplicationHelper.getApplicationContext().getBean("manager");
        Map<String, Integer> sales = manager.weeklySales();

        XYSeries series = new XYSeries("Sales");
        LinkedHashSet<DecimalPoint> points = new LinkedHashSet<DecimalPoint>();

        for( String string : sales.keySet() ){

            DecimalPoint point = new DecimalPoint(series, string, sales.get(string));
            point.setName( string + " " + sales.get(string).toString());
            points.add( point );
        }

        series.setSeriesPoints(points);
        addSeries(series);
        setWidth("279px");
        setHeight("240px");

    }
}