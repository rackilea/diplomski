@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "maintenanceSchedule")
public interface MaintenanceScheduleRepository extends CouchbasePagingAndSortingRepository<MaintenanceSchedule, String> {

    List<MaintenanceSchedule> deleteByCompanyIdAndMaintenancePlanId(String companyId, String maintenancePlanId);

    List<MaintenanceSchedule> deleteByCompanyIdAndResourceIdAndMaintenancePlanIdIn(String companyId, String resourceId,
                                                                               List<String> maintenancePlanIds);

}