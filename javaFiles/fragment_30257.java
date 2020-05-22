@RunWith(PowerMockRunner.class)
@PrepareForTest({ InquireOfferElementsImpl.class, PropertyManager.class })
public class MypersonalClassTest {

   // Code Down There

@Before
public static void setUpStatic() {
        Properties props = System.getProperties();
        props.setProperty("source.value", "TYPICAL");
        props.setProperty("source.allow", "PRIMER");
} // everything will work file 
 }