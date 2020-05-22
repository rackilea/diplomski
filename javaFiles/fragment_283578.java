public ISchoolMember Deserialize(string jsonString)
{ 
    var o = JObject.Parse(jsonString);
    return (UserType)o["Type"] switch
    {
        UserType.Teacher => JsonConvert.Deserialize<Teacher>(jsonString),
        UserType.Student => JsonConvert.Deserialize<Student>(jsonString),
        _ => throw new ArgumentException("...")
    };
}