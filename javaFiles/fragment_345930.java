import static org.junit.Assert.*;
#if($CLASS_NAME.contains("Service"))
//Import whatever you need for services here.
#end
#if($CLASS_NAME.contains("Controller"))
//Import whatever you need for controllers here.
#end
#parse("File Header.java")
#if($CLASS_NAME.contains("Controller"))
#set($CLASS_SUFFIX = ".class" )
@RunWith(SpringRunner.class)
@RunWithMock
@WebMvcTest(controllers = $CLASS_NAME$CLASS_SUFFIX)
#end
#if($CLASS_NAME.contains("Service"))
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = NONE)
#end
public class ${NAME} {
  ${BODY}
}