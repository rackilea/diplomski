public class MyKey
    {
        public long ID { get; set; }
    }

    static void Main(string[] args)
    {
        Dictionary<MyKey, String> myMap = new Dictionary<MyKey, string>();
        myMap.Add(new MyKey() { ID = 100 }, "One");
        myMap.Add(new MyKey() { ID = 200 }, "Two");
        myMap.Add(new MyKey() { ID = 300 }, "Three");

        long searchKey = 200;
        string value = myMap[myMap.Keys.FirstOrDefault(x => x.ID == searchKey)];
    }