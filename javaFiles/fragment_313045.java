@RequestMapping(value = BASE_PATH + "/getAccountBalances", method = RequestMethod.GET)
public SseEmitter getAccountBalances(@QueryParam("accountId") Integer[] accountIds) {
  final SseEmitter emitter = new SseEmitter();

  new Thread(new Runnable() {

    @Override
    public void run() {
      try {
        for (int xx = 0; xx < ids.length; xx++) {
          Thread.sleep(2000L + rand.nextInt(2000));

          BalanceDetails balance = new BalanceDetails();
          ...
          emitter.send(emitter.event().name("accountBalance").id(String.valueOf(accountIds[xx]))
                  .data(balance, MediaType.APPLICATION_JSON));
        }

        emitter.send(SseEmitter.event().name("complete").data("complete"));
        emitter.complete();
      } catch (Exception ee) {
        ee.printStackTrace();
        emitter.completeWithError(ee);
      }
    }
  }).start();

  return emitter;
}