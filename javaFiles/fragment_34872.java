class MatchAnyCompleterTest extends Specification {
    def "Testing matches"() {
        setup:
            def mac = new MatchAnyCompleter([
                    "somevalue",
                    "welcome_trashcan",
                    "pecan_seaweed",
                    "yeswecan",
                    "canwest",
                    "nomatchhere"
            ])
            def cmdLine = new ParsedLine() {
                // non-implemented methods were removed for simplicity
                @Override
                List<String> words() {
                    return ["we","can"]
                }
            }
            List<Candidate> selected = []
            mac.complete(null, cmdLine, selected)
        expect:
            selected.each {
                println it.value()
            }
            assert selected.size() == 4
    }
}