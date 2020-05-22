function myMap() {
    var arr=document.getElementById("Focus").getAttribute("value").split(",")
    var mapProp= {
        center:new google.maps.LatLng(arr[0],arr[1]),
    zoom:5,
    };
    var map=new
    google.maps.Map(document.getElementById("googleMap"),mapProp);
}