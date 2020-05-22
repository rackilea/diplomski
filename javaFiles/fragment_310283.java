try {
    Class.forName("javax.servlet.Filter");
    return true;
} catch(Exception e) {
    return false;
}