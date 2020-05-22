Iterator<Suggest.Suggestion<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>>> iterator = searchResponse.getSuggest().iterator();
    Suggest.Suggestion<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>> suggestion;

    List<String> resultList = null;
    while (iterator.hasNext()) {
        suggestion = iterator.next();
        resultList = fn.getEntries().get(0).getOptions().stream()
            .map((Suggest.Suggestion.Entry.Option option) -> option.getText().toString())
            .collect(Collectors.toList());
    }

    return resultList;