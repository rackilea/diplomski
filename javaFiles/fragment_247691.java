public String parseURL(String url, Map<String, String> params)
{
    Builder builder = Uri.parse(url).buildUpon();
    for (String key : params.keySet())
    {
        builder.appendQueryParameter(key, params.get(key));
    }
    return builder.build().toString();
}