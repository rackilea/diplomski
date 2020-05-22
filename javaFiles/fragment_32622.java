interface Booking {
    // methods required at any stage of processing
}

interface BookingProcessor {
    void process(Booking booking);
}

@Service("BookingSourceDataService")
class BookingSourceDataService implements BookingProcessor {

    @Autowired
    @Qualifier("CustomerValidationService")
    private BookingProcessor nextProcessor;

    @Override
    public void process(Booking booking) {
        // fetch booking source data, populate the Booking object
        nextProcessor.process(booking);
    }

}
@Service("CustomerValidationService")
class CustomerValidationService implements BookingProcessor {

    @Autowired
    @Qualifier("CustomerCreationService")
    private BookingProcessor nextProcessor;

    @Override
    public void process(Booking booking) {
        // validate customer, populate the Booking object
        nextProcessor.process(booking);
    }

}