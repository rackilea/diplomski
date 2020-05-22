modelMapper.addConverter(new Converter<Source, Dest>() {
    public Dest convert(MappingContext<Source, Dest> context) {
         Source s = context.getSource();
         Dest d = context.getDestination();
         d.setYyy(s.getXxx() + d.getYyy()); // example of using dest's existing field
         return d;
     }
});