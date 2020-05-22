message Header {
    required fixed32 length = 1;
    required fixed32 type = 2; // Note: don't use an enum here, as the values are serialized to varint, which simply kills your fixedness.
}

message Login {
    required string nickname = 1;
    required string password = 2;
}

enum ErrorType {
    BAD_HEADER = 0;
    WRONG_PASSWORD = 1;
}

message Error {
    required ErrorType type = 1;
    optional string message = 2;
}