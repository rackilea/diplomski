if (health > 0){
    char[] bars = new char[health];
    Arrays.fill(bars, '|');
    entity.setCustomName(entity.getCustomName()+" " + new String(bars));
} else {
    entity.setCustomName(entity.getCustomName()); // no bars to add
}