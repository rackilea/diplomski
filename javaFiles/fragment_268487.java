@RestController
    public class CustController {
        @Autowired
        @Qualifier("branchDao")
        BranchJDBCTemplate branchTemplate;  
        ...
    }