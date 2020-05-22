ArrayList<Double> x = new ArrayList<Double>(); 
ArrayList<Double> y = new ArrayList<Double>(); 

... above code ...

TimeSeries series = new TimeSeries("Number of cores");
for (int i=0;i<x.size();i++){
    series.add(x.get(i),y.get(i));
}