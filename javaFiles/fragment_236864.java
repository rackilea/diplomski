public <X> List<X> createData(Supplier<X> datum, Integer length){
    List<X> values = new ArrayList<X>();
    for(int i = 0; i < length; i++)
    {
        values.add(datum.get());
    }
    JOptionPane.showMessageDialog(null, values.size());
    return values;
}