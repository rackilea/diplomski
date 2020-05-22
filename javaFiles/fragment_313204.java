import org.apache.commons.lang3.text.StrSubstitutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

@Test
public class TestClass {

@Test
public void test() {

    Map<String, String> messageValues = new HashMap<String, String>();
    messageValues.put("killer", "Johnson");
    messageValues.put("target", "Quagmire");
    StrSubstitutor sub = new StrSubstitutor(new CaseInsensitiveStrLookup<String>(messageValues), "&(", ")", '\\');

    String format2 = sub.replace("Information: &(killer) killed &(target)!");
    String format = sub.replace("Information: &(KILLER) killed &(TARGET)!");
    Assert.assertEquals(format, "Information: Johnson killed Quagmire!");
    Assert.assertEquals(format2, "Information: Johnson killed Quagmire!");
}
}