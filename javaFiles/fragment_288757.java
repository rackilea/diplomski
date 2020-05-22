public class NestedBean {

    private String foo;    
    private List<NestedBean> list;      
    private Map<String, NestedBean> map = new LazyMap<String, NestedBean>(NestedBean.class);

}