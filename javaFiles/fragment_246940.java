$ cat tst.awk         
match($0,/\s+*<Attribute Name="([^"]+)" Value="([^"]+)".*/,a) { count[a[1]][a[2]]++ }
END {
    print "\nIf you just want to see the count of all error codes:"
    name = "ErrorCode"
    for (value in count[name]) {
        print name, value, count[name][value]
    }

    print "\nOr if theres a few specific attributes you care about:"
    split("ErrorId ErrorCode",names,/ /)
    for (i=1; i in names; i++) {
        name = names[i]
        for (value in count[name]) {
            print name, value, count[name][value]
        }
    }

    print "\nOr if you want to see the count of all values for all attributes:"
    for (name in count) {
        for (value in count[name]) {
            print name, value, count[name][value]
        }
    }
}