JavaPlot p = new JavaPlot();
    p.setTerminal(png);
    p.set("polar","");
    FunctionPlot func = new FunctionPlot("cos(2*t)");
    p.addPlot(func);
    p.addPlot("sin(t)");
    p.setPersist(false);
    p.plot();