function ajax_get_json() {
    var hr = new XMLHttpRequest();
    hr.open("GET", "sList.json", true);
    hr.setRequestHeader("Content-type", "application/json", true);
    hr.onreadystatechange = function () {
        if (hr.readyState == 4 && hr.status == 200) {
            //Initialize the data parse from JSON file
            var data = JSON.parse(hr.responseText);
            //Initializes s and sets the destination location as s Id within HTML body


            var s = document.getElementById("s");
            //Initialize serDate.innerHTML as null
            s.innerHTML = "";
            //Loops all objects and data within the sermonList.json file

            var keys = Object.keys(obj).reverse();
            for (i = 0; i < keys.length; i++) {
                var obj = data[keys[i]];

                //Displays s dates, icon, anchors the audioSrc to the icon
                /*
                    //WANT THESE ITEMS TO BE DISPLAYED FROM HIGHEST INDEX TO LEAST
                    //s3, s2, s1
                    */
                s.innerHTML += "Date: " + obj.date + " <a href='" + obj.audioSrc + "' target='blank'><img src='" + obj.iconSrc + "'></a><br />";
            }
        }
    }
    hr.send(null);
    //Displays text while loading
    s.innerHTML = "requesting...";
}