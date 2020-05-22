MultiResult multiResult = expect.expect(anyOf(contains(">"), contains("#")));
if (multiResult.getResults().get(0).isSuccessful()) {
    expect.sendLine("enable");
    expect.expect(contains("assword:"));
    expect.sendLine(password);
} else if (multiResult.getResults().get(1).isSuccessful()) {
   expect.expect(contains("#"));
}