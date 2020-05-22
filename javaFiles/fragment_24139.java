public void add(Measurable x) {
    sum = sum + x.getMeasure();
    if (count == 0 || maximum.getMeasure() < x.getMeasure())
        maximum = x;  // here maximum gets set to the object passed in, but we don't know its type at this point
    count++;
}