public class OrgWithEmpCount {
  private Organisation org;
  private Long empCount;
  public OrgWithEmpCount(Organisation org, Long empCount) {
    this.org = org;
    this.empCount = empCount;
  }
}


Select new full.package.OrgWithEmpCount(o, count(e.employeeId)) 
from Organisation o, IN(o.employees) e 
group by o.orgId, o.orgName, o.whateverElse