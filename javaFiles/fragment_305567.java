boolean allDoubleArr = true;
for(Object[] o : args) {
    if(!(o instanceof Double[])) {
        allDoubleArr = false;
        break;
    }
}