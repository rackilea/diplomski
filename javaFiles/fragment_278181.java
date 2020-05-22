this.localContext=this.getLocalContext();
BasicClientCookie cookie = new BasicClientCookie("acrsession", this.token);
cookie.setDomain(this.Domain);
cookie.setPath(this.path);
this.cookieStore.addCookie(cookie);
 localContext.setAttribute(ClientContext.COOKIE_STORE, this.cookieStore);