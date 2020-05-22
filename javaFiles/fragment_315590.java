public void attack(Animal other) {
    catAttack(other); <-------- Problem here
}

private void catAttack(Cat other) {
    // Maybe a meow showdown wins the fight, no need to get physical
}

private void catAttack(Dog other) {
    // Dogs are dangerous, run!
}