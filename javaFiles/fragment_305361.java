class BadMap implements WidgetMap{

    private WidgetMap next = null;
    private Widget key = null;
    private Widget val = null;

    public void put(Widget _key, Widget _value){
        if(key == null){
            key = _key;
            val = _value;
        }else if(key.equals(_key)){
            val = _value;
        }else if(next != null){
            next.put(_key, _value);
        }else{
            next = new BadMap();
            next.put(_key, _value);
        }
    }

    public Widget get(Widget _key){
        if(key != null && key.equals(_key)){
            return val;
        }else if(next != null){
            return next.get(_key);
        }else{
            return null;
        }
    }

}