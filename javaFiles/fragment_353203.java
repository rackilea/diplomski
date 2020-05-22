float[] positions = new float[text.length()];
for (int i = 0; i < positions.length; i++) {
    if (i == 0) {
        // first position is the starting offset
        positions[0] = run.xAdvances.get(0);
    } else {
        // current position is the previous position plus its advance
        positions[i] = positions[i - 1] + run.xAdvances.get(i);  
    }         
}