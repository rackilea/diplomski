public class FrenchSpringScenarioTest<ETANTDONNE, QUAND, ALORS> extends
    SpringScenarioTest<ETANTDONNE, QUAND, ALORS> {

    public ETANTDONNE etant_donne() {
         return getScenario().given( "etant donné" );
    } 

    public QUAND quand() {
         return getScenario().when( "quand" );
    } 

    public ALORS alors() {
         return getScenario().then( "alors" );
    } 
}