class TotalServiceImpl implements TotalService{

    private static final Function<PricingDto, Double> PRICING_DTO_TRANSFORMER =
        new PricingDtoTransformer();

    private static class PricingDtoTransformer implements
        Function<PricingDto, Double>{

        public PricingDtoTransformer(){
        }

        @Override
        public Double apply(final PricingDto pricingDto){
            return pricingDto.getTax() + pricingDto.getPrice()
                + pricingDto.getTips();
        }
    }

    public List<Double> getListDouble(final List<PricingDto> pricingDtos){
        final List<Double> totalList =
            Lists.transform(pricingDtos, PRICING_DTO_TRANSFORMER);
        for(final Double d : totalList){
            // print them.
        }
        return totalList;
    }

}