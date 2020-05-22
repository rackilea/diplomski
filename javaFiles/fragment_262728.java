static List<PeopleByDays> intersect(Set<Set<PeopleByDays>> powerSet) {
        List<PeopleByDays> intersected = new ArrayList<PeopleByDays>();
        for (Set<PeopleByDays> powerElement: powerSet) {
            PeopleByDays intersection = null;
            if (powerElement.isEmpty()) {
                intersection = new PeopleByDays();
            } else for (PeopleByDays peeps: powerElement) {
                if (intersection == null) {
                    intersection = new PeopleByDays(peeps);
                } else {
                    intersection.retainAll(peeps);
                }
            }
            intersected.add(intersection);
        }
        return intersected;
    }