package commands

import org.crsh.cli.Usage
import org.crsh.cli.Command
import org.crsh.command.InvocationContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.batch.core.launch.JobLauncher

class hello {

    @Usage("Say Hello")
    @Command
    def main(InvocationContext context) {
        BeanFactory beanFactory = (BeanFactory) context.getAttributes().get("spring.beanfactory");
        JobLauncher jobLauncher = beanFactory.getBean(JobLauncher.class);
        if(jobLauncher != null){
            return jobLauncher.toString();
        }else{
            return "NULL";
        }
        return "hello j";
    }

}