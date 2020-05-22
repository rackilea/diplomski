@Test
public void testEscapeForLogs() {
  assertEquals("without linebreaks/tabs stays the same", "lala", e scapeForLogs("lala"));
  assertEquals("empty string is fine", "", escapeForLogs(""));
  assertEquals("newline gets escaped", "\\\\n", escapeForLogs("\n"));
  assertEquals("two newlines", "\\\\n\\\\n", escapeForLogs("\n\n"));
  assertEquals("tab", "\\\\t", escapeForLogs("\t"));
  assertEquals("return carridge gets escaped", "\\\\n", escapeForLogs("\r"));
  assertEquals("return carridge+newline gets converted", "\\\\n", escapeForLogs("\r\n"));
  assertEquals("newline before cr+nl", "\\\\n\\\\n", escapeForLogs("\n\r\n"));
  assertEquals("2 cr+nl", "\\\\n\\\\n", escapeForLogs("\r\n\r\n"));
  assertEquals("some combination", "lala\\\\nlalala\\\\n\\\\nla\\\\tla", escapeForLogs("lala\nlalala\n\nla\tla"));
}