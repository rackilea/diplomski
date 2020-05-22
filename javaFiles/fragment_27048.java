print "<ul>";
String liText=null;
while (res = fetch(database)) {
    if (liText!=null) {
        print ("<li>" + liText + "</li>");
    }
    liText=res.col['data'];
}

if (liText!=null) {
    print ("<li style='the last element style'>" + liText + "</li>");
}
print "</ul>";