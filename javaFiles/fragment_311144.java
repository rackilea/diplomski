public void checkAddress(List<Address> addresses) throws Exception{
        if(addresses == null)
            throw new Exception(Thread.currentThread().getStackTrace()[2].getClassName() + "." + Thread.currentThread().getStackTrace()[2].getMethodName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + ": Invalid parameter: list is null");
        for(Address a : addresses)
            if(a == null)
                throw new Exception(Thread.currentThread().getStackTrace()[2].getClassName() + "." + Thread.currentThread().getStackTrace()[2].getMethodName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + ": Invalid list item: object is null");
    }

}