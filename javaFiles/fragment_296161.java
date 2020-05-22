String os = System.getProperty("os.name").toLowerCase();
if (os.indexOf("windows 9") > -1) {
  cmd = "CMD.exe /c";
} else if ((os.indexOf("nt") > -1) || (os.indexOf("windows 2000") > -1) || (os.indexOf("windows xp") > -1)) {
  cmd = "COMMAND.com /c";
}