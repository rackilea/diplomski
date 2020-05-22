Uri.Builder builder = new Uri.Builder();
builder.scheme("http").encodedAuthority(url);
for (Map.Entry<String, String> entry : mRequestParams.entrySet()) {
  builder.appendQueryParam(entry.key, entry.value);
}
url = ...