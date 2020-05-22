private void removeSameCar(List<Overlay> mapOverlays, Car car) {
    Iterator<Overlay> it = mapOverlays.iterator();
    while (it.hasNext()) {
        Overlay overlay = it.next();
        if(overlay instanceof CustomPinpointOverlay && 
                ((CustomPinpointOverlay) overlay).getItem(0).getCar().getNumberPlate().equals(car.getNumberPlate())){
            it.remove();
        }
    }
}