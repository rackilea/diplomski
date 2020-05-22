FullTextQuery jpaQuery = ftem.createFullTextQuery(query, ProductModel.class);
jpaQuery.setProjection( FullTextQuery.THIS, "Image_url" );
List results = jpaQuery.list();
Object[] firstResult = (Object[]) results.get(0);
ProductModel productModel = firstResult[0];
String imageUrl = firstResult[1];