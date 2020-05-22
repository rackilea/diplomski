new Specification<MyEntity>() {
  @Override
  public Predicate toPredicate(Root<MyEntity> root, CriteriaQuery<?> cq, CriteriaBuilder builder) {
      List<SingularAttribute<MyEntity, ?>> tempAttributes = new ArrayList<>();
      for (SingularAttribute<MyEntity, ?> attribute : root.getModel().getDeclaredSingularAttributes()) {
          if (attribute.getJavaType().getSimpleName().equalsIgnoreCase("string")) {
              tempAttributes.add(attribute);
          }
      }

      final Predicate[] predicates = new Predicate[tempAttributes.size()];

      for (int i = 0; i < tempAttributes.size(); i++) {
          predicates[i] = builder.like(root.<MyEntity>get(tempAttributes.get(i).getName()), finalText);
      }

      return builder.or(predicates);
  }
};