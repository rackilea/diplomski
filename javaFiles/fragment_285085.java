for(int i = 0; i<result.length; i++){
    for(int j = 0; j<result[i].length; j++){
        if(i<a.length && j < a[i].length){
            result[i][j] += a[i][j];
        }
        if(i<b.length && j < b[i].length){
            result[i][j] += b[i][j];
        }

    }
}
return result;