public boolean checkStrength(){
    if (!inGame.entities.isEmpty() && strength <= 0) {
        return true;
    }
    return false;
}