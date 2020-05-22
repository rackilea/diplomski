function initMap() {
var myLatLng = {lat: -25.363, lng: 131.044};
var map = new google.maps.Map(document.getElementById('map'), {
zoom: 4,
center: {lat: -25.363882, lng: 131.044922 }
});

var marker = new google.maps.Marker({
position: myLatLng,
map: map,
draggable: true,
});

google.maps.event.addListener(map, 'click', function(e) {
updateMarkerPosition(marker,e);
});
}

function updateMarkerPosition(marker, e){
marker.setPosition(e.latLng);
}