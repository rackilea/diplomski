public static void main(String[] args )
    {
        logger.info("Starting Inquiry Batch Process");

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberInquiryService memberInquiryService = (MemberInquiryService) context.getBean("memberInquiryService");

        int pendingRecords = memberInquiryService.getPendingRecordCount();

        logger.info("Current Number Of Pendinig Records (" + pendingRecords + ")");

        logger.info("Ending Inquiry Batch Process");
    }