@Service
public class MyServiceImpl implements MyService{   
    @Autowired
    private MyDao myDao;    
    @Transactional
    public List<T> transactionalMethod() {
        return this.myDao.get(4L);
    }   
    public List<T> notTransactionalMethod(){
        return transactionalMethod();
    }
}