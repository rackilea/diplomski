@Autowired
private static ScreenDao screenDao;

@PostConstruct
public static void setScreenDao(ScreenDao newScreenDao) {
    screenDao = newScreenDao;
}

@PostConstruct
public ScreenDao getScreenDao() {
    return screenDao;
}