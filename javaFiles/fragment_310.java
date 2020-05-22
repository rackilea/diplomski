@Autowired
private ApplicationContext applicationContext;

private TaskNoticeRepository taskNoticeRepository;

@PostConstruct
public void init() {
    taskNoticeRepository = applicationContext.getBean(TaskNoticeRepository.class);
}