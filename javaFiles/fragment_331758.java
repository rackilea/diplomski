@Test
public void requestIdRegex()
{
    String gitCommit = "146916ad3ed2935cc82ebed705dc27213f907808 add partner request id = e4614f35-1f3c-4316-85c1-016bfffcc928";
    String requestId = null;

    Pattern pattern = Pattern.compile("(\\w+) add partner request id = ([\\w-]+)");
    Matcher matcher = pattern.matcher(gitCommit);
    while (matcher.find()) {
        requestId =  matcher.group(2);
    }
    assertThat(requestId, equalTo("e4614f35-1f3c-4316-85c1-016bfffcc928"));
}