public class Rootobject
    {
        public Type Type { get; set; }
    }

    public class Type
    {
        public String attribute1 { get; set; }
        public String attribute2 { get; set; }
        public String attribute3 { get; set; }
        public Recordlist recordList { get; set; }
    }

    public class Recordlist
    {
        public Record1[] record1 { get; set; }
    }

    public class Record1
    {
        public Object field { get; set; }
    }