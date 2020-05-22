//get text 1 by ajax
    function getText1(urlstarted) {
        xmlHttp = false;
        if (window.XMLHttpRequest) { // Mozilla, Safari,...
            xmlHttp = new XMLHttpRequest();
            if (xmlHttp.overrideMimeType) {
                // set type accordingly to anticipated content type
                //http_request.overrideMimeType('text/xml');
                xmlHttp.overrideMimeType('text/html');
            }
        } else if (window.ActiveXObject) { // IE
            try {
                xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e) {
                try {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e) {}
            }
        }
        if (!xmlHttp) {
            alert('Cannot create XMLHTTP instance');
            return false;
        }

        var url=urlstarted+"/jsp/viewText1.jsp"; //put the link to ur Ajax page here
         xmlHttp.onreadystatechange = startAjaxingText;
        xmlHttp.open("GET", url, true);
        xmlHttp.send(null);
    }
    function startAjaxingText() {
        if (xmlHttp.readyState != 4) {

            document.getElementById('image').style.display='block' ;
            document.getElementById('result').style.display='none' ;
        }

        if (xmlHttp.readyState == 4) {

            if (xmlHttp.status == 200) {




                    document.getElementById('image').style.display='none' ;
                    document.getElementById('result').style.display='block';
                    document.getElementById('result').innerHTML = xmlHttp.responseText;


            } else {
                alert("There was a problem with the request.");
            }
        }

    }
//get text 2 by ajax
    function getText2(urlstarted) {
        xmlHttp = false;
        if (window.XMLHttpRequest) { // Mozilla, Safari,...
            xmlHttp = new XMLHttpRequest();
            if (xmlHttp.overrideMimeType) {
                // set type accordingly to anticipated content type
                //http_request.overrideMimeType('text/xml');
                xmlHttp.overrideMimeType('text/html');
            }
        } else if (window.ActiveXObject) { // IE
            try {
                xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e) {
                try {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e) {}
            }
        }
        if (!xmlHttp) {
            alert('Cannot create XMLHTTP instance');
            return false;
        }

        var url=urlstarted+"/jsp/viewText2.jsp"; //put the link to ur Ajax page here
         xmlHttp.onreadystatechange = startAjaxingText2;
        xmlHttp.open("GET", url, true);
        xmlHttp.send(null);
    }
    function startAjaxingText2() {
        if (xmlHttp.readyState != 4) {

            document.getElementById('image').style.display='block' ;
            document.getElementById('result').style.display='none' ;
        }

        if (xmlHttp.readyState == 4) {

            if (xmlHttp.status == 200) {




                    document.getElementById('image').style.display='none' ;
                    document.getElementById('result').style.display='block';
                    document.getElementById('result').innerHTML = xmlHttp.responseText;


            } else {
                alert("There was a problem with the request.");
            }
        }

    }