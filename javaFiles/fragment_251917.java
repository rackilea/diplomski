Cookie cookie = cooks.next();
sb.append("$Version=0; ");
sb.append(cookie.getName()+"="+cookie.getValue());
if (cooks.hasNext()) {
    sb.append(";");
}
sb.append("; $Path=/");