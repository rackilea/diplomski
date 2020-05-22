message TutorialAPIResponse {
    repeated Foo items = 1;
}
message Foo {
    repeated google.protobuf.Any values = 1;
}