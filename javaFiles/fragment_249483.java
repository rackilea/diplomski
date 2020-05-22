Map<...> result = data.get(val);
if(null == result) {
    result = new HashMap();
    data.put(val, result);
}
return out;