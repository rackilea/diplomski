Cookie[] ck=request.getCookies();
for(int i=0; i<ck.length; i++) {
    if("un".equals(ck[i].getName())) {
        pw.write("Hello" +ck[i].getValue());
    }
}