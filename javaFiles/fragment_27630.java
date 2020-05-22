CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<ArticleType> criteria = criteriaBuilder.createQuery(ArticleType.class);
    Root<ArticleType> root = criteria.from(ArticleType.class);
    criteria.select(root).distinct(true);

    Join<ArticleType, ArticleTypeVarianteOption> joinOptions = root.join("articleTypeVarianteOptionCollection");

    if (fetchRelations != null)
    {
        for (String fetchReln : fetchRelations)
        {
            FetchParent<ArticleType, ArticleType> fetch = root;

            for (String reln : fetchReln.split("\\."))
            {
                FetchParent<ArticleType, ArticleType> originalFetch = fetch;
                for (String childReln : reln.split(":"))
                {
                    fetch = originalFetch.fetch(childReln, JoinType.LEFT);
                }
                originalFetch = fetch;
            }
        }
    }

    Predicate[] predArray = new Predicate[2];
    predArray[0] = criteriaBuilder.equal(joinOptions.get("atvoIndexConfig"), configId);
    predArray[1] = criteriaBuilder.equal(joinOptions.get("atvoIndexArticleType"), articleTypeId);

    criteria.where(predArray);

    TypedQuery<ArticleType> typedQry = entityManager.createQuery(criteria);
    ArticleType articleTypeResult;

    try
    {
        articleTypeResult = typedQry.getSingleResult();
    }
    catch (NoResultException ex)
    {
        articleTypeResult = null;
    }
    return articleTypeResult;