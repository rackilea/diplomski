public class RoutingDatasource extends AbstractRoutingDataSource {

   @Override
   protected Object determineCurrentLookupKey() {
     return selectRandom("DB1DS","DBDS2");
   }
}