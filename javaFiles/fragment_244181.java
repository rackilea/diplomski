public int size() {
    return this.size;
}

public boolean contains(Grade grade) {
    for(int i = 0; i < this.size; i++) {
        if(this.gradeArray[i].equals(grade)) {
            return true ;
        }
    }
    return false;
}