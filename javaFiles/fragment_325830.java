public <T extends QueryBean, TT extends Persistible> 
Collection<T> queryMany(Class<T> type, 
                        QueryConfig<TT> config, 
                        Map<String, Object> parameters) {
    executeQueryEntity(type, config.getTargetEntity(), parameters);
}