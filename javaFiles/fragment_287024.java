for(int i=0; i<forecast.estimasiPoin().ukuran(); i++){
    Vector<Object> rml = new Vector<>();
    rml.add(i);
    rml.add("");
    rml.add(aturDesim.format(forecast.estimasiPoin().pada(i)));
    rml.add(aturDesim.format(forecast.intervalPrediksiAtas().pada(i)));
    rml.add(aturDesim.format(forecast.intervalPrediksiAtas().pada(i)));
    tb.addRow(rml);
}