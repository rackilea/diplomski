// MODULE com.example.codec.api

public interface CodecFactory { }

module com.example.codec.api {
    exports com.example.codec;
    uses com.example.codec.CodecFactory;
}


// MODULE com.example.codec.api

public class ExtendedCodecsFactory {

    public static CodecFactory provider() {
        return new CodecFactory() { };
    }

}

module com.example.codec.impl {
    requires com.example.codec.api;
    provides com.example.codec.CodecFactory
        with com.example.impl.ExtendedCodecsFactory;
}