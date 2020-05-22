private double rollingTotal(double d, boolean initFlag) {
    if(initFlag) vals = new Queue<Integer>();
    else {
        if(vals.size() == 7) // replace 7 with i.
            total -= vals.pop().intValue();
        }
        vals.push(d);
        total += d;
    }
    return total;
}