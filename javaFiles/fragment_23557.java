public class MyTableImpl implements MyTableService {

    // other methods, @Autowiring, etc

    @Override
    @Transactional
    public void truncateMyTable() {
        myTableRepository.truncateMyTable();
    }
}