func test() {
    do {
        try bar()
    } catch {
        print("\(error) has been caught!")
    }
}