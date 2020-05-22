} catch (Throwable e) {
    System.out.println(e.getMessage());

    _log.error(e.getMessage());
    if (priceList != null) {
        priceList.setReadCorrectly(false);
    }

}