public class AlertasAcceptanceTest extends SeleniumAcceptanceTest {

    @Test
    public void alertas_index__must_show_table_with_4_lines() {
        //given
        doLogin();
        //when
        $.browser.openUrl(urlBase + "/alertas/" );
        int linesInTheTable = $("table tr").size();
        //then
        assertThat(linesInTheTable , is(4));
    }
}