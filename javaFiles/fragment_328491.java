Request request = requestWithManyHeaders(
    url,
    body,
    Arrays.asList("auth", "tag1", "tag2"),
    Arrays.asList("authValue", "tag1Value", "tag2Value")
);