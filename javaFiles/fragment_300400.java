String line = "[1322110800] LOG ROTATION: DAILY";
Pattern pt = Pattern.compile("\\[(\\d+)\\]");
Matcher m = pt.matcher(line);
if (m.find()) {
    Date dt = new Date(Long.parseLong(m.group(1)) * 1000);
    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
    line = m.replaceFirst('['+ sdf.format(dt) +']');
}

System.out.println(line);