public class GoodsController {

    private GoodsService goodsService;

    public void updateGoods(Integer id, String name, BigDecimal cost) {
        Goods goods = goodsService.read(id);
        goods.setName(name);
        goods.setCost(cost);
        goodsService.write(goods);
    }

}