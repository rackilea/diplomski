RealmList<Chapter> chapters = new RealmList<Chapter>();
chapters.add(new Chapter());
chapters.add(new Chapter());
chapters.add(new Chapter());
chapters.add(new Chapter());

chapters = realm.copyToRealm(chapters);
novel.setChapters(chapters);