@Aspect
public class GoodsLogger {
    @Before(value = "execution(* org.antonu.service.GoodsService.write(..)) && args(goods)")
    public void logWrite(Goods goods) {
        // Get current user and timestamp,
        // Write it to goods_log table, as well as goods data
    }
}