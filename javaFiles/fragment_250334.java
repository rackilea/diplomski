String str = "id_not=\"autoincrement\"; id_obj=\"-\"; id_tr=\"-\"; id_pgo=\"-\"; typ_not=\"\"; tresc=\"Nie wystawił\"; datetime=\"-\"; lon=\"-\"; lat=\"-\";";

Pattern p = Pattern.compile("tresc(.*?);");
Matcher m = p.matcher(str);

if (m.find()) {
    System.out.println(m.group());
}