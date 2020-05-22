syntax = "proto2";
package by.dev.madhead;
option java_outer_classname = "SO";

message Candidate {

}

enum ErrorType {
    ERROR = 0;
    WARNING = 1;
}

message ErrorMessage {
    required string message = 1;
    required ErrorType type = 2;
}

message Response {
    repeated Candidate candidates = 1;
    map<string, ErrorMessage> errors = 2;
}