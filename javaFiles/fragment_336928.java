ProductPart productPart  = (ProductPart) sessionFactory
                .getCurrentSession()
                .createCriteria(ProductPart.class)
                .add(Restrictions.eq("part.part", cPartId))
                .add(Restrictions.eq("product", productId)).uniqueResult();//here similarly access your Product's @Id
                                                                           //something like product.productId