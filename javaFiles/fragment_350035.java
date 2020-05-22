function setNewSessionCookie() {
    var b = get_vid();
    var d;
    var e;
    var a;
    var c = new Date();
    c.setTime(c.getTime());
    a = getCookie("ses");
    if (!a) {
        b = get_vid();
        if (!b) {
            return
        }
        d = (new Date()).getTime();
        a = b + "_" + d
    }
    e = new Date(c.getTime() + (1000 * 60 * 15));
    document.cookie = name + "ses=" + a + ";expires=" + e.toGMTString()
}