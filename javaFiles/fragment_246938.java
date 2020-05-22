$ cat tst.awk
BEGIN{ OFS="," }
match($0,/\s+*<Error ErrorCode="([^"]+)" ErrorDescription="([^"]+)".*/,a) {
    code = a[1]
    desc[code] = a[2]
    count[code]++
    files[code][FILENAME]
}
END {
    print "Count", "ErrorCode", "ErrorDescription", "List of files it occurs in"
    for (code in desc) {
        fnames = ""
        for (fname in files[code]) {
            fnames = (fnames ? fnames " " : "") fname
        }
        print count[code], code, desc[code], fnames
    }
}
$
$ awk -f tst.awk file
Count,ErrorCode,ErrorDescription,List of files it occurs in
1,Code,Description,file