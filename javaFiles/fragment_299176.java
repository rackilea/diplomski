Double getResult(index i) {
    if ( calculations.get(i).isDone() )  {
        return calculations.get(i).get();
    } else {
        // Do something else
    }
}