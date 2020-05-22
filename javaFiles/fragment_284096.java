//I know the subreport is in first detail band so I access this directly 
JRBaseBand detailBand1 = (JRBaseBand) report.getDetailSection().getBands()[0];
List<JRChild> elements = detailBand1.getChildren(); //Get all children
for (JRChild child : elements) {
    if (child instanceof JRBaseSubreport){ //This is a subreport
        JRBaseSubreport subreport = (JRBaseSubreport)child;
        String expression= ""; //Lets find out the expression used
        JRExpressionChunk[] chunks = subreport.getExpression().getChunks();
        for (JRExpressionChunk c : chunks) {
            expression +=c.getText();
        }
        System.out.println(expression); 
        //Here you could do code to load the subreport into a JasperReport object
    }
}