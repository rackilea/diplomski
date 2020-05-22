Document document = kml.createAndSetDocument().withName("MyMarkers");

document.createAndAddPlacemark().withName("London, UK").withOpen(Boolean.TRUE)  
    .createAndSetPoint().addToCoordinates(-0.126236, 51.500152);    

document.createAndAddPlacemark().withName("Somewhere near London,UK").withOpen(Boolean.TRUE)
    .createAndSetPoint().addToCoordinates(-0.129800,52.70‌​0152);