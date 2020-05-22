package test;

message Foo {
    optional int32 i = 1;
    extensions 10 to 99999;
}

message Bar {
    extend Foo {
        optional int32 j = 10001;
    }
}