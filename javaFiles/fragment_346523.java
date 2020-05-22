public boolean isLuxuyBuilding() {
   if (unitsPerFloor <= 2 && hasElevator && hasCentralAir) {
      return true;
    } else {
      return false;
    }
}