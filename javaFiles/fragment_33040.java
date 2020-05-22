package widget;

option java_package = "protobuf.example";
option java_outer_classname = "WidgetsProtoc";

message Widget {
    required string id = 1;
    required string name = 2;
}

message WidgetList {
    repeated Widget widget = 1;
}