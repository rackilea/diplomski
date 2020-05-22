public static Logger logger;
static FileHandler fh;

logger = Logger.getLogger("Log");
logger.setUseParentHandlers(false);     

String sFileName = new SimpleDateFormat("dd-MMM-yyyy").format(new Date());

fh = new FileHandler(sPath + "//" + sFileName + ".txt", true);
logger.addHandler(fh);

SimpleFormatter formatter = new SimpleFormatter();
fh.setFormatter(formatter);