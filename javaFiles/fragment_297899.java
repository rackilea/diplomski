public Object randomObject(Object[] objects, float[] chances){
    //Implement here validations, about arrays size and chances values.

    float random = (float) Math.random();
    float acumulatedChance = 0f;

    for (int i = 0; i < chances.length; i++) {
        acumulatedChance += chances[i];
        if (acumulatedChance >= random) {
            return objects[i];
        }            
    }
    return objects[objects.length-1];        
}