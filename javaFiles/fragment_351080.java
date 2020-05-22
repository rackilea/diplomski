StringBuilder sb = new StringBuilder(url);
url.indexOf("?") > -1 ? sb.append("&") : sb.append("?");

// loop over your paramaters and append them like in Noel M's example

url = sb.toString();