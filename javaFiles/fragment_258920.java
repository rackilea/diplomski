listView.setOnKeyTyped(new EventHandler<KeyEvent>() {
    @Override
    public void handle(KeyEvent event) {
        if (event.getCharacter() != null) {
            //in case of same character typed more times = search next occurence
            if (searchText.equals(event.getCharacter())) {
                searchTextSkip++;
            } else {
                //in case typing more characters relatively quickly = append character
                if (System.currentTimeMillis() - searchTextLastTyped < 1000) {
                    searchText += event.getCharacter();
                //typing new character after pause = new search
                } else {
                    searchText = event.getCharacter();
                }
            }
            searchTextLastTyped = System.currentTimeMillis();

            boolean found = false;
            int skipped = 0;
            for (T item : getItems()) {
                if (getTextValue(item).toUpperCase().startsWith(searchText.toUpperCase())) {
                    if (searchTextSkip > skipped) {
                        skipped++;
                        continue;
                    }
                    setValue(item);
                    found = true;
                    break;
                }
            }

            //reset to first occurence
            if (!found) {
                searchTextSkip = 0;
            }
        }
    }
});