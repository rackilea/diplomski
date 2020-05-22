function get_vid() {
    var b;
    var a = getCookie("vsid");
    if (!a) {
        return false
    }
    if (a.search(",") == "-1") {
        b = Base64.decode(a)
    } else {
        b = a
    }
    return b.split(",")[0]
}