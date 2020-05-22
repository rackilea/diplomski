$ cat tst.awk
BEGIN{ OFS="," }
/[[:space:]]+*<Error / {
    split("",n2v)
    while ( match($0,/[^[:space:]]+="[^"]+/) ) {
        name = value = substr($0,RSTART,RLENGTH)
        sub(/=.*/,"",name)
        sub(/^[^=]+="/,"",value)
        $0 = substr($0,RSTART+RLENGTH)
        n2v[name] = value
    }
    code = n2v["ErrorCode"]
    desc[code] = n2v["ErrorDescription"]
    count[code]++
    if (!seen[code,FILENAME]++) {
        fnames[code] = (code in fnames ? fnames[code] " " : "") FILENAME
    }
}
END {
    print "Count", "ErrorCode", "ErrorDescription", "List of files it occurs in"
    for (code in desc) {
        print count[code], code, desc[code], fnames[code]
    }
}
$
$ awk -f tst.awk file
Count,ErrorCode,ErrorDescription,List of files it occurs in
1,Code,Description,file