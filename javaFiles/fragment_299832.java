//redirect to new blog
  setTimeout( redirectTumblr, 3000 );

  function redirectTumblr() {
    location.replace('http://oddhour.tumblr.com' + location.pathname);
  }