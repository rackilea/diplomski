graph.post(new Runnable(){
    @Override
    public void run(){
        graph.removeAllSeries();
        graph.addSeries(series);        
    }
});