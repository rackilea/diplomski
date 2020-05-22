synchronized (this) {
            for (listModel current_item : items) {
                String current_section = current_item.getName().substring(0, 1).toUpperCase(Locale.getDefault());

                if (!prev_section.equals(current_section)) {
                    mListItems.add(current_section);
                    mListItems.add(current_item.getName());
                    // array list of section positions
                    mListSectionPos.add(mListItems.indexOf(current_section));
                    prev_section = current_section;
                } else {
                    mListItems.add(current_item.getName());
                }
            }
        }