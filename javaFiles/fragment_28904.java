public class DepartmentStaffListToStaffCountConverter extends AbstractConverter<Set<Staff>, Integer> {

    @Override
    protected Integer convert(Set<Staff> staffList) {
        if(staffList != null) {
            return staffList.size();
        } else {
            return 0;
        }
    }
}