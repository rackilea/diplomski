Exception in thread "main" java.io.NotSerializableException: Generic$$Lambda$1/321001045
        - element of array (index: 0)
        - array (class "[LObject;", size: 1)
/* ! */ - field (class "invoke.SerializedLambda", name: "capturedArgs", type: "class [LObject;") // <--- !!
        - root object (class "invoke.SerializedLambda", SerializedLambda[capturingClass=class Generic, functionalInterfaceMethod=Comparator.compare:(LObject;LObject;)I, implementation=invokeInterface Comparator.compare:(LObject;LObject;)I, instantiatedMethodType=(LInteger;LInteger;)I, numCaptured=1])
    at java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1182)
    /* removed */
    at java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:348)
    at Generic.main(Generic.java:27)