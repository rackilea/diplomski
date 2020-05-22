@Transactional
public void saveBoth(){
try {
    xyzDao.persist(beanXYZ);
    abcDao.persist(beanABC);

    } catch (Exception e) {
    logger.error("This is error : " + e);
    logger.fatal("This is fatal : " + e);
    }
}