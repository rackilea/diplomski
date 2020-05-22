for (int i = 0; i < angles.length; i++) {
    boolean meetsCondition = false;
    while (!meetsCondition) {
        for (int k = 0; k < angles.length; k++){
            if(i != k){
                if(abs(angles[i] - angles[k]) <= radians(30)){
                    angles[i] = radians(random(360));
                    meetsCondition = false;
                    break;
                }
            }
        }
        meetsCondition = true; //if the for loop completes, it has met the condition.
    }
}