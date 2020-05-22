public List<IDevice> findByObject(Device device) {
    Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Device.class);

    if (device.getIpAdress() != null && device.getIpAdress().trim().length() > 0 ) {
        criteria.add(Restrictions.like("ipAdress", device.getIpAdress()));
    }
    if (device.getSerialNumber() != null && device.getSerialNumber().trim().length() > 0 ) {
        criteria.add(Restrictions.like("serialNumber", device.getSerialNumber()));
    }
    if (device.getOwner() != null && device.getOwner().getSiteName() != null && device.getOwner().getSiteName().trim().length() > 0) {
        criteria.createCriteria("owner").add(Restrictions.like("siteName", device.getOwner().getSiteName()));
    }
            if (device.getInstallDate() != null) {
                criteria.add(Restrictions.like("installDate", device.getInstallDate()));
            }