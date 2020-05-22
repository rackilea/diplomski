for(Entry <String, Tag> e : allTags.entrySet()) {
        Tag tag = e.getValue();
        String translation = tag.getTranslation(Language.EN);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            if(rs.getString("name").equals(translation)) {
                tag.setAlternativeKey(translation);
                break;
            }
        }
    }