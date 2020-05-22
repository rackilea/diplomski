POST https://maps.googleapis.com/maps/api/place/add/json?key=AddYourOwnKeyHere HTTP/1.1
Host: maps.googleapis.com

{
  "location": {
    "lat": -33.8669710,
    "lng": 151.1958750
  },
  "accuracy": 50,
  "name": "Google Shoes!",
  "phone_number": "(02) 9374 4000",
  "address": "48 Pirrama Road, Pyrmont, NSW 2009, Australia",
  "types": ["shoe_store"],
  "website": "http://www.google.com.au/",
  "language": "en-AU"
}