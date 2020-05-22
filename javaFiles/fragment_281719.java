class Processor {
    static Dictionary<string, int> _encodings = new Dictionary<string, int>() {

        { "mov", 0x00000032 },
        { "add", 0x00000051 }
        // etc.
    };

    static Dictionary<string, Action<object, object>> _callbacks = 
        new Dictionary<string, Action<object, object>>() {

            { "mov", executeMov },
            { "add", executeAdd } 
            // ect
    };

    void executeMov(object o1, object o2) {
        // ...
    }

    void executeAdd(objecy o1, object o2) {
        // ...
    }
}