public Enum UserType { Teacher, Student, /* possibly other types */ }

public interface ISchoolMember 
{
    public string Name { get; }
    ..
    public UserType Type { get; }
}