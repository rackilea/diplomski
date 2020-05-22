@Transactional
class MachoBO {
 void handleEverything(String daoName) {
   DAO dao = getDAOUsingReflection(daoName);
   dao.insertData();
 }