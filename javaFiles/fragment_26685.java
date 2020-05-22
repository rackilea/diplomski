Double[][] matriz = {{1d,5d,2d,8d,4d,70d,50d,80d},{3d,7d,4d,2d,6d,60d,30d,70d},{8d,1d,6d,4d,2d,10d,40d,60d}};

    List<List> result = new ArrayList<>();
    for(Double[] array : matriz){
        result.add( Arrays.asList(array) );
    }