public T keepStateBetweenTests() {
    if (INSTANCE == null)
        INSTANCE = getInstance(activityTestRule); 

    return (T)INSTANCE;
}