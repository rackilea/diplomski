@AfterReturning(value="(execution(* search(..)) )" +
        "&& target(com.erp.core.repo.IBaseRepository) " +
        "&& args(..)",returning="returnList")
public void decrypt(List returnList) throws Exception
{
    for (Object [] objs : (List<Object[]>) returnList) {
        for (int i = 0; i < objs.length; i++) {
            if (objs[i] instanceof String) {
                objs[i]= EncryptUtil.decrypt(objs[i]);
            }
        }
    }
}