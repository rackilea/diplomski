@Override
public AccountStates find(User artOwner, Artwork artwork) {


 final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    final CriteriaQuery<AccountStates> criteriaQuery = builder.createQuery(AccountStates.class);

    Root<AccountStates> root = criteriaQuery.from(AccountStates.class);
    Predicate p1 = builder.and(builder.equal(root.get("artwork"), artwork),
            builder.equal(root.get("artOwner"), artOwner));

    criteriaQuery.where(p1);

    TypedQuery<AccountStates> typedQuery = this.getEntityManager().createQuery(criteriaQuery);

    return typedQuery.getSingleResult();
    }
}