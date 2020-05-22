// jjs -scripting ora2csv.js -- "select 'hi' from dual" jdbc:oracle:thin:@host:1521:XE user pass

function newJjsEngineWith (jars) {
  var ua = Java.type("java.net.URL[]"); var urls = new ua(jars.length);
  for(var i=0; i<jars.length; i++) {
    var u=new java.net.URL(new java.io.File(jars[i]).toURL());
    urls[i] = u;
  }
  var loader = new java.net.URLClassLoader(urls);
  java.lang.Thread.currentThread().setContextClassLoader(loader);
  var nsef = Java.type("jdk.nashorn.api.scripting.NashornScriptEngineFactory");
  var sa = Java.type("java.lang.String[]"); var args = new sa(2 + $ARG.length);
  args[0] = "-scripting"; args[1] = "--";
  for(var i=0;i<$ARG.length;i++) { args[i+2] = $ARG[i]; }
  return new nsef().getScriptEngine(args, loader);
}

var jjs = newJjsEngineWith(["ojdbc8.jar"]);

function hereDoc(f) { return f.toString().slice(14,-3); }

var code = hereDoc(function(){/*
var q = $ARG[0]; // select 'hello' from dual
var c = $ARG[1]; // jdbc:oracle:thin:@host:1521:XW
var u = $ARG[2]; // username
var p = $ARG[3]; // password
var conn = java.sql.DriverManager.getConnection(c, u, p);
var stmt = conn.createStatement(); rset = stmt.executeQuery(q);
var row=0;
while (rset.next()) {
  row++; var rowBuf = new java.lang.StringBuilder();
  var meta = rset.getMetaData();
  for(var col=0; col< meta.getColumnCount(); col++) {
    var cell = rset.getString(col+1);
    if (cell == null) { cell = ""; }
    rowBuf.append(cell.replaceAll(";",","));
    if (col < meta.getColumnCount()-1) { rowBuf.append(";"); }
  }
  print(rowBuf.toString());
}
stmt.close();
*/});

jjs.eval(code);