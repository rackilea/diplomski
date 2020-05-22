public void DeserializeAndDoStuff(string jsonString)
{ 
    var teacherOrStudent = JObject.Parse(jsonString);
    if (teacherOrStudent["StudentId"] != null) // it is a student!
    {
        Student s = teacherOrStudent.ToObject<Student>();
        // ... do stuff with the student object
    } 
    else if (teacherOrStudent["TeacherId"] != null) // it is a teacher!
    {
        Teacher t = teacherOrStudent.ToObject<Teacher>();
        // ... do stuff with the teacher object
    }
    else 
    {
        throw new ArgumentException("The given object is neither a teacher or a student.");
    }
}