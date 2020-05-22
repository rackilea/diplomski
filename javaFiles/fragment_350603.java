@Transactional
public boolean tryLock(ConfigEnum lockable) {
    Config lock = configRepository.findOneByName(lockable.getSetting());
    if("1".equals(lock.getValue()) {
        return false;
    }
    lock.setValue("1");
    configRepository.save(lock);
    return true;
}