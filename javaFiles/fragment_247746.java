Async {
  concurrent.future(Ok("ok"))
} transform { result =>
  println(result.header.status)
  result
}