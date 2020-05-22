HttpURLConnection httpURLConnection;
URL url = new URL("http://www.google.com");
httpURLConnection = (HttpURLConnection) url.openConnection();
StringBuilder builder = new StringBuilder();
builder.append(httpURLConnection.getResponseCode())
       .append(" ")
       .append(httpURLConnection.getResponseMessage())
       .append("\n");

Map<String, List<String>> map = httpURLConnection.getHeaderFields();
for (Map.Entry<String, List<String>> entry : map.entrySet())
{
    if (entry.getKey() == null) 
        continue;
    builder.append( entry.getKey())
           .append(": ");

    List<String> headerValues = entry.getValue();
    Iterator<String> it = headerValues.iterator();
    if (it.hasNext()) {
        builder.append(it.next());

        while (it.hasNext()) {
            builder.append(", ")
                   .append(it.next());
        }
    }

    builder.append("\n");
}

System.out.println(builder);