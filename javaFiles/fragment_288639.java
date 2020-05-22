<!DOCTYPE html>
<html> 
<head> 
 <meta http-equiv="content-type" content="text/html; charset=UTF-8" /> 
 <title>Google Maps Markers</title> 
   <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=places"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
   <script type="text/javascript">

   var map;
   // Creates the map
   function initialize() {
       map = new google.maps.Map(document.getElementById('map'), {
       zoom: 10,
       center: new google.maps.LatLng(21.1458004, 79.0881546), //For Nagpur
       mapTypeId: google.maps.MapTypeId.ROADMAP
     });
   }

   // This function takes an array argument containing a list of marker data
  function generateMarkers(locations) {
     for (var i = 0; i < locations.length; i++) {
      new google.maps.Marker({
        position: new google.maps.LatLng(21.1011957, 79.1026544),
        map: map,
        title: locations[i][0]
      });
   }
 }
</script>
</head> 
<body> 
<div id="map" style="width: 500px; height: 400px;"></div>
<script type="text/javascript">

window.onload = function () {
    initialize();
    var loc2 = [];
    // I have created by getting the city and country. Then find Latitude and Longitude.
    var address = 'Nagpur,India';
    geocoder = new google.maps.Geocoder();
    geocoder.geocode( { 'address': address}, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            loc2.push("['Nagpur'," + 21.2333 + "," + 79.2000 +"]");
            locations1 = "[" + loc2 + "]";
            generateMarkers(eval(locations1));
        } 
        else {
            alert("Geocode was not successful for the following reason: " + status);
        }
    });
};
</script>
</body>
</html>