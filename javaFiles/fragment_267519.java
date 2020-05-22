List<Sample> c = new ArrayList<>();
for(Sample s : available) {
    if(s.getSoil()!=null) {
        c.add(s);
    }
}
available.removeAll(c);