message Animal {
  enum Type {
    Cat = 1;
    Dog = 2;
  }
  required Type type = 1;
  optional Cat cat = 100;
  optional Dog dog = 101;
}

message Cat {
  optional bool declawed = 1;
}
message Dog {
  optional uint32 bones_buried = 1;
}