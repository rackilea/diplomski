private LinkedList<Entity> collectAuthors(ResultSet results) {
        LinkedList<Entity> temp = new LinkedList<>();
        while (results.hasNext()) {
            Entity a = new Entity();
            QuerySolution row = results.next();
            String fullName = row.get("name").toString().substring(0, row.get("name").toString().indexOf("@"));
            String biography = row.get("desc").toString().substring(0, row.get("desc").toString().indexOf("@"));
            a.setTitle(fullName);
            a.setWikiID(Integer.parseInt(row.get("wiki").toString().substring(0, row.get("wiki").toString().indexOf("^"))));
            if (!row.get("thumb").toString().isEmpty())
                a.setPictureURL(row.get("thumb").toString());

            a.setBiography(biography);
            temp.add(a);
            System.out.println("FAAT" + a.getTitle());
        }
        return temp;
    }