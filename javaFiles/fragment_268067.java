@Autowired
UserDao usrdao;

//private UserDao usrdao = new UserDaoImp();

@Transactional
public List<Users> getAllUsers() {        
    return usrdao.list();
}