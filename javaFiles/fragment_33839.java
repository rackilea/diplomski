public double calculateAverage(int year) {
    int index = year - 1907; //extract 1907 into a CONSTANT or some other variable if possible

    double sum = 0.0;
    for (double monthRain : years[index]) { //is `years` visible?
        sum += monthRain;
    }

    return sum / years[index].length; //`years[index].length` should be 12, but maybe you have a blank month data?
}