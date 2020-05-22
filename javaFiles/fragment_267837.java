FileOutputStream st = null;
try {
    st = new FileOutputStream(b);
    ...
} catch(Exception e) {
    ...
} finally {
    st.close();
}