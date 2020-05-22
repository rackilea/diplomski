username = getCookie(userCookieName);

// Get from cookie.
function getCookie(name) {
  if (document.cookie) {
    index = document.cookie.indexOf(name);
    if (index !== -1) {
      f = (document.cookie.indexOf("=", index) + 1);
      t = document.cookie.indexOf(";", index);
      if (t === -1) {
        t = document.cookie.length;
      }
      return(document.cookie.substring(f, t));
    }
  }
  return ("");
}