//url: the url to call through ajax
//callback: a function to execute when it is done
//error: a function for if there was a problem with the request
function load(url, callback, error){
    var xhr;

    // here we check what version of AJAX the browser supports
    if(typeof XMLHttpRequest !== 'undefined') 
        xhr = new XMLHttpRequest();
    else {
        //internet explorer is stupid...
        var versions = ["MSXML2.XmlHttp.5.0", 
                        "MSXML2.XmlHttp.4.0",
                        "MSXML2.XmlHttp.3.0", 
                        "MSXML2.XmlHttp.2.0",
                        "Microsoft.XmlHttp"]

         for(var i = 0, len = versions.length; i < len; i++) {
            try {
                xhr = new ActiveXObject(versions[i]);
                break;
            }
            catch(e){}
         } // end for
    }


    function ensureReadiness() {
        //not done yet
        if(xhr.readyState < 4) {
            return;
        }

        // all is well  
        if(xhr.readyState === 4 && xhr.status === 200) {
            callback(xhr.responseText);
        } else {
            error(xhr);
        }      
    }
    //here we assign the function above to check if the AJAX call is finished
    xhr.onreadystatechange = ensureReadiness;

    //send the request
    xhr.open('GET', url, true);
    xhr.send('');
}

//we call the function like this:
load('http://example.com/page', 
  function(successText){
      //get the paragraph and assign the value
      var p = document.getElementById('value');
      p.innerHTML = successText;
  },
  function(error){
      console.log(error);
})