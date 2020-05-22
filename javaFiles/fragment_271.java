Predicate pr1 = cb.like(article.get(Article_.code), "%" + searchQuery + "%");
Predicate pr2 = cb.like(article.get(Article_.oem_code), "%" + searchQuery + "%");
Predicate pr3 = cb.conjunction();

for (String str : busquedaSplit) {
    Predicate newPredicate = cb.like(article.get(Article_.description), "%" + str + "%");
    pr3 = cb.and(pr3, newPredicate);
}

disjunction = cb.or(pr1, pr2, pr3);

predicates.add(disjunction);