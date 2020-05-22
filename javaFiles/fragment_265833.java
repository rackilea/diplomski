if (fruitOval.intersects(bucketBox) == true) {
    score++;
    scoreLbl.setLabel( "" + score); // New.
    remove(fruit);
    addFruit(random.nextInt(1, 3), random.nextInt(0, 300 - 20), 0); // New.
}