public class Generics
{

static public void main(String[] args) {
    Generics.test();
    }

static private void test() {
    Map<String,Object> ctx=new TreeMap<String,Object>();
    Map<String,Object> map=new TreeMap<String,Object>();
    Map<String,Object> tst;

    ctx.put("Test",map);
    tst=uncheckedCast(ctx.get("Test"));
    }

@SuppressWarnings({"unchecked"})
static public <T> T uncheckedCast(Object obj) {
    return (T)obj;
    }

}