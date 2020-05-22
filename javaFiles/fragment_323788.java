if (user != null && user.getPassword().equals(password)) {
    //...
    loginFailed = false;
} else {
    //...
    loginFailed = true;
}
request.setAttribute("loginFailed", loginFailed);