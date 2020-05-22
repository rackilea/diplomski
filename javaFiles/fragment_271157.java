@Override
public int compareTo(customText o) {

    int result = url.compareTo(o.url);
    if (result != 0) {
        return result;
    }
    return ip.compareTo(o.ip);
}