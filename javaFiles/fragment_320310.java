<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.awt.*"%>
<%@ page import="java.io.*"%>
<%@ page import="org.jfree.chart.*"%>
<%@ page import="org.jfree.chart.entity.*"%>
<%@ page import="org.jfree.data.general.*"%>

<%

            DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("JavaWorld", new Integer(75));
        pieDataset.setValue("Other", new Integer(25));

            JFreeChart chart = ChartFactory.createPieChart("Discounts Used by Category ", data, true, true, false);
            //chart.setBackgroundPaint(new Color(222, 222, 255));
                final PiePlot plot = (PiePlot) chart.getPlot();
                plot.setBackgroundPaint(Color.white);
                plot.setCircular(true);

            try {

                final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                final File file1 = new File(getServletContext().getRealPath(".") + "/images/charts/piechart.png");

                ChartUtilities.saveChartAsPNG(file1, chart, 600, 400, info);
            } catch (Exception e) {
                System.out.println(e);

            }
        }
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pie Chart</title>
</head>
<body>
    <IMG SRC="piechart.png" WIDTH="600" HEIGHT="400" BORDER="0"
        USEMAP="#chart">
</body>
</html>