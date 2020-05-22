StringBuilder sb = new StringBuilder(); 
for (String s : db.getit("table")) {
    sb.append(s);
    sb.append("\n");
}
intent.putExtra(Intent.EXTRA_TEXT, sb.toString());