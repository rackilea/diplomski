@prefix : <urn:train:>.
@prefix xsd: <http://www.w3.org/2001/XMLSchema#>.

:train1
  :name "RE 1" ;
  :description "Platform 1" ;
  :arrival "2015-04-14T18:00:40Z"^^xsd:dateTime ;
  :departure "2015-04-14T18:02:40Z"^^xsd:dateTime ;
  :over ("Station1" "Station2" "Station3") ;
  :destination "Padaborn" .