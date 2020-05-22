Converter<DogData, DogInfo> myConverter = new Converter<DogData, DogInfo>()
    {
        public DogInfo convert(MappingContext<DogData, DogInfo> context)
        {
            DogData s = context.getSource();
            DogInfo d = context.getDestination();
            d.setName(s.getName());
            d.setLarge(s.getMass() > 25);
            return d;
        }
    };

    mm.addConverter(myConverter);