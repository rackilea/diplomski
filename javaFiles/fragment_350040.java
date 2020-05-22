private final static String PAYPAL_WEB_IPN_TXN_PARAM = "txn_id";
private final static String PAYPAL_WEB_IPN_AMOUNT_PARAM = "mc_gross";
private final static String PAYPAL_WEB_IPN_PAYMENT_STATUS_PARAM = "payment_status";
private final static String PAYPAL_WEB_IPN_PAYMENT_STATUS = "Completed";

@Resource(name = "payPalConfigurationMap")
private Map<String, String> configurationMap;

private OAuthTokenCredential oAuthTokenCredential;

@PostConstruct
public void init() {
    Properties properties = new Properties();
    properties.putAll(configurationMap);
    PayPalResource.initConfig(properties);

    oAuthTokenCredential = new OAuthTokenCredential(
            configurationMap.get(Constants.CLIENT_ID),
            configurationMap.get(Constants.CLIENT_SECRET),
            configurationMap
    );
}


public DonationDTO validateWebIPN(HttpServletRequest request) throws Exception {
    IPNMessage ipnlistener = new IPNMessage(request, configurationMap);
    boolean isIpnVerified = ipnlistener.validate();

    String paymentStatus = ipnlistener.getIpnValue(PAYPAL_WEB_IPN_PAYMENT_STATUS_PARAM);

    if (isIpnVerified && paymentStatus.equalsIgnoreCase(PAYPAL_WEB_IPN_PAYMENT_STATUS)) {
        String amount = ipnlistener.getIpnValue(PAYPAL_WEB_IPN_AMOUNT_PARAM);
        String tx = ipnlistener.getIpnValue(PAYPAL_WEB_IPN_TXN_PARAM);

        // irrelevant code

        return donationDTO;
    }else{
        String exceptionMessage = "Problem when requesting info from PayPal service";
        logger.error(exceptionMessage);
        throw new Exception(exceptionMessage);
    }
}