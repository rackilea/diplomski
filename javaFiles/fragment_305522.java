String features = "1,4,5";
int featureSize = 3;

DetachedCriteria criteria = DetachedCriteria.for(Product.class, "product");

criteria.add(Restrictions.sqlRestriction(String.format("(SELECT COUNT(*) FROM product_feature pf where pf.feature_id in(%s) and pf.product_id={alias}.id)=%d", features, featureSize)));