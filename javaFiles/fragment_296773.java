for(int i = 0; i < cookies.length; i++){
    cn = cookies[ i ].getName();
    cv = cookies[ i ].getValue();
    cv = cv.concat(color);
    cookies[i].setValue(cv);
    response.addCookie(cookies[i]);
}