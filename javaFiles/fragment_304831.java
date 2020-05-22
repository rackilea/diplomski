for(int j = 0; i < is.size() && ts.size(); i++){
    int i = is.get(j);
    int t = ts.get(j);
    g.drawLine(20 + t, this.getHeight() - 50 - i,
               20 + t, this.getHeight() - 50);
}