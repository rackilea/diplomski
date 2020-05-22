public class PhoneCodeServiceTest {

@Test
public void testNull() {
    PhoneCodeService phoneCodeService = new PhoneCodeService();
    assertEquals(null, phoneCodeService.getPhonecode(null));
}

@Test
public void testCodes() {
    PhoneCodeService phoneCodeService = new PhoneCodeService();
    final String[] CODES = {"86101"};
    for (String code : CODES) {
        assertEquals("984", phoneCodeService.getPhonecode(code));
    }
}