task dummyCI(type: DummyTask) {
    doFirst {
        dummy {
            env = 'ci'
        }
    }
}