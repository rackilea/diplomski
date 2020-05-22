Converter<Integer, Boolean> convertMassToLarge = new Converter<Integer, Boolean>()
    {
        public Boolean convert(MappingContext<Integer, Boolean> context)
        {
            // If the dog weighs more than 25, then it must be large
            return context.getSource() > 25;
        }
    };

    PropertyMap<DogData, DogInfo> mymap = new PropertyMap<DogData, DogInfo>()
    {
        protected void configure()
        {
            // Note: this is not normal code. It is "EDSL" so don't get confused
            map(source.getName()).setName(null);
            using(convertMassToLarge).map(source.getMass()).setLarge(false);
        }
    };

    mm.addMappings(mymap);