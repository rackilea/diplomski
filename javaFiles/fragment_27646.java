$("#btnfbShare").click(function(event){                         
    FB.init({
        appId      : '10761986057291117',
        xfbml      : true,
        version    : 'v2.4'
    });

    FB.ui({
        method: 'share',
        href: 'https://developers.facebook.com/docs/'
        }, function(response){});
});