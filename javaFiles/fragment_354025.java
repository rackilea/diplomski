final HttpPost httpPost = new HttpPost("http://...");

final ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
params.add(new BasicNameValuePair("a_param", username));
params.add(new BasicNameValuePair("a_second_param", password));

//  add the parameters to the httpPost
HttpEntity entity;
try
{
    entity = new UrlEncodedFormEntity(params);
    httpPost.setEntity(entity);
}
catch (final UnsupportedEncodingException e)
{
    // this should never happen.
    throw new IllegalStateException(e);
}
HttpEntity httpEntity = httpPost.getEntity();

try
{
    List<NameValuePair> parameters = new ArrayList<NameValuePair>( URLEncodedUtils.parse(httpEntity) );
}
catch (IOException e)
{
}