public void update(Observable o, Object arg) {
    Avg avg = (Avg) o; 
    double observations_avg = avg.getAverage();
    if (observations_avg >= limit) {
          System.out.println(disp());
     }
}