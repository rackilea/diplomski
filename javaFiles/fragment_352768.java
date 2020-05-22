HttpEntity entity = null;

Object value = params.get(AQuery.POST_ENTITY);

if(value instanceof HttpEntity){                        
     entity = (HttpEntity) value;                        
} else {
    //urlencoded POST data
}