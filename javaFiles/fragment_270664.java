struct TestStruct {
  1: optional E f1 = E.A,
  2: required i64 f2 = 1,
  3: required string f3 = "f3",
  4: Nested f4 = { f1 : 24, f2 : "i am required", f3 : E.B }
  5: Union f5 = { f1 : "one" }
  6: map<string, i64> f6 = { "hello": 42, "goodbye":24 },
  7: set<i64> f7 = [ 1, 2, 3, -4 ]
  8: list<string> f8 = ["bla","bla","bla"]
}