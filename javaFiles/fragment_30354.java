import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StepConfig {

    @Autowired
    private StepBuilderFactory steps;

    @Bean
    public Step step() {
        return steps.get("step")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("hello world");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }
}