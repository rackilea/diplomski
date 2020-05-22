syntax = "proto2";

import "google/protobuf/descriptor.proto";

message EnumProto {
  extend google.protobuf.EnumValueOptions {
    optional string name = 50000;
    optional string singleCharCode = 50001;
  }

  enum PaxType {
    ADULT = 0 [(name) = "ADT", (singleCharCode) = 'A'];
    CHILD = 1 [(name) = "CNN", (singleCharCode) = 'C'];
    INFANT = 2 [(name) = "IFT", (singleCharCode) = 'I'];
  }
}