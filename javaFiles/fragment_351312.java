|  Welcome to JShell -- Version 9.0.1
|  For an introduction type: /help intro

jshell> java.text.SimpleDateFormat dmy = new java.text.SimpleDateFormat("d-M-y");
dmy ==> java.text.SimpleDateFormat@596ca10

jshell> dmy.parse("13-02-1994")
$2 ==> Sun Feb 13 00:00:00 CST 1994

jshell> dmy.parse("1994-02-13")
$3 ==> Wed Jul 18 00:00:00 CDT 2018

jshell> dmy.isLenient()
$4 ==> true

jshell> dmy.setLenient(false)

jshell> dmy.parse("1994-02-13")
|  java.text.ParseException thrown: Unparseable date: "1994-02-13"
|        at DateFormat.parse (DateFormat.java:388)
|        at (#6:1)