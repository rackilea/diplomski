void centro(){
        Random rand = new Random();
        for(int i=0;i<k;i++){
            int r = rand.nextInt(ilosc);
            Data c_data = new Data(0,0);  //<== add this line
            c_data.x = data_v.get(r).x;
            c_data.y = data_v.get(r).y;
            centroids.add(c_data);
        }
        for(int j=0;j<centroids.size();j++) //print centroids.x and centroids.y
    }