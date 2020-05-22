func call() {
    do {
        try parseLevel()
    } catch LevelParsingException.InvalidLevelContent {
        print("something")
    } catch  {
        print("something else")
    }
}