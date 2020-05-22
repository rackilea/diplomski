import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
....

@Test
public void ListOfTheFiles(){

  List<File> result  = directoryWalker.walk("path");
  assertThat(Arrays.asList(new File("path\\start.fxml")), is(result));