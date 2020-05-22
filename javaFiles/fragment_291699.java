implementation 'com.github.imperiumlabs:GeoFirestore-Android:v1.2.0'
/*
 * You have to do this only one time for document
 * so the best is after the document upload to Firestore.
 */

//The id of the document you want to add the location
String documentId = documentReference.id;
GeoPoint point = new GeoPoint(/*lat,long of your point*/);
geoFirestore.setLocation(documentId, point);