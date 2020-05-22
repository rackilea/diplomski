public class MainApp {
    public static void main(String[] args) {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");

        String[] springConfig = { "C:\\XXXX\\src\\main\\resources\\META-INF\\spring\\XXXXX-job.xml" };

        ApplicationContext context = new FileSystemXmlApplicationContext(springConfig);
        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("XXXJob");

        try {
            JobExecution execution = jobLauncher.run(job, new JobParameters());
            System.out.println("Exit Status : " + execution.getStatus());

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
}