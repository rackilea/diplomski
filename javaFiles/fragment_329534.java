@RequestMapping(value="/dummyApi", method=RequestMethod.POST)
public DummyRet dummyApi(@RequestBody Args args) {
  LOGGER.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
  LOGGER.info("Arguments received:");
  LOGGER.info("arg1: " + args.getArg1().toString());
  LOGGER.info("arg2: " + args.getArg2().toString());
  LOGGER.info("arg3: " + args.getArg3().toString());
  LOGGER.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
  return new DummyRet("foo");
}