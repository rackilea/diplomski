public List<Complex> getComplex() {
    List<Complex> copy = new ArrayList<Complex>(complexs.size());
    for (Complex c : complexs) 
        copy.add(c.clone());
    return copy;
}