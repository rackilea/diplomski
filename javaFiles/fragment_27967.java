data_type getVariance(data_type[] array){
    data_type mean = getMean(array);
    data_type var = 0;
    for(int i =0; i < array.length; i++){
        var += getProbabilityOf(array[i])*(array[i]-mean)*(array[i]-mean);
    }
    return var;
}
data_type getMean(data_type[] array){
    data_type mean = 0;
    for(int i =0; i < array.length; i++){
        mean += getProbabilityOf(array[i], array)*array[i];
    }
    return mean;
}
double getProbabilityOf(data_type data, data_type[] array){
    return [number of appearances of data in array / size of array];
}