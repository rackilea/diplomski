int poolSize = tpe.getPoolSize();
int maximumPoolSize = tpe.getMaximumPoolSize();
if (poolSize >= maximumPoolSize || poolSize > tpe.getActiveCount()) {
    return super.offer(e);
} else {
    return false;
}