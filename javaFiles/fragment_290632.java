public static List<T> CreateListForSampleType<T>(T sample)
{
    return new List<T>();
}

...

Employee x = new Employee();
var list = CreateListForSampleType(x);