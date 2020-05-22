HttpEntity httpEntity = response.getEntity();
String str = "";
if (httpEntity != null) {
    str = EntityUtils.toString(entity);
    System.out.println(str);
}