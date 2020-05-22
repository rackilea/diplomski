class MatchAnyCompleter implements Completer {
    protected final List<Candidate> candidateList = []

    MatchAnyCompleter(List<String> list) {
        assert list
        list.each {
            candidateList << new Candidate(AttributedString.stripAnsi(it), it, null, null, null, null, true)
        }
    }

    @Override
    void complete(final LineReader reader, final ParsedLine commandLine, final List<Candidate> selected) {
        assert commandLine != null
        assert selected != null
        selected.addAll(candidateList.findAll {
            Candidate candidate ->
                commandLine.words().stream().allMatch {
                    String keyword ->
                        candidate.value().contains(keyword)
                }
        })
    }
}