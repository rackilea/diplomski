List<Lecture> l = new ArrayList<>();
List<Tutorial> t = new ArrayList<>();
for (Session s : sessions) {
    if (s instanceof Lecture) {
        l.add((Lecture) s);
    }
      else if(s instanceof Tutorial) {
        t.add((Tutorial) s);
    }
}