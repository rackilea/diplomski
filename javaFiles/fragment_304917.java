message Message1 {
   required string a = 1;
   required string b = 2;
}

message Message2 {
   required int64 id = 1;
   required string data = 2;
}




message WrapperMessage {
    required int64 commonField = 1;
    oneof msg {
        Message1 m1 = 2;
        Message2 m2 = 3;
    }   
}