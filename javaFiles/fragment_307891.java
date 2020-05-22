@Configuration
static class TestConfiguration{

    @Bean
    public InterviewInformationDao getInterviewInformationDao(){
        return new InterviewInformationDaoImpl();
    }
}