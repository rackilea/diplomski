package common; 

option java_package = "my.java.package";
option java_outer_classname = "MessageProto";

message MyMessage {
  optional string dataCenter = 1 [default = DEFAULT_DC];
  optional int64 clientId = 2;
  optional int64 poolId = 3;
  optional int64 dataCount = 4;
  optional string body = 5;
}