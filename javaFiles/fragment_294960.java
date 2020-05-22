String createdAt = (String) attrs.get("whenCreated").get();
SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
Date cre = null;
try {
     cre = sdf.parse(createdAt);
} catch (ParseException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
sfd = new SimpleDateFormat("yyyy-MM-dd");
mp.put("ldap_created_at", sdf.format(cre) );