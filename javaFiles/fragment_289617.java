try {
    if (someCondition) {
        return 1;
    }
    if (someOtherCondition) {
        throw new Exception();
    }
}
catch (Exception e) {
    System.out.println("Got here because of exception");
    return 2;
}
finally {
    System.out.println("Got here");
}
System.out.println("May not have gotten here");
return 3;