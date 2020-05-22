public static Result detail(Integer productId)
{
    Product product = .... (productId);
    return ok(productDetail.render(product));
}
// with the route of course