public enum ROLE_TYPE { FULL_TIME, PART_TIME }

public class student {

    private ROLE_TYPE attendanceRole;

    public SetRoleType( ROLE_TYPE type )
    {
        this.attendanceRole = type;
    }

    public GetRoleType()
    {
        return attendanceRole;
    }
}