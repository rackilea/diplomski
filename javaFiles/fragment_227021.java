message FunctionInformationMap {
  repeated group Entry = 1 {
    required int32 id = 2;
    required string source_name = 3;
    required int32 line_number = 4;
    required string module_name = 5;
    required int32 size = 6;
    required string name = 7;
    required string compiled_source = 8;
  }
}