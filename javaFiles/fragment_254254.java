import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("foo-reader")
@Scope("step")
public final class MyReader implements ItemReader<MyData> {
  @Override
  public MyData read() throws Exception {
    //...
  }

  @Value("#{jobParameters['fileName']}")
  public void setFileName(final String name) {
    //...
  }
}