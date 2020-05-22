// Create the list of parameters for the charge
Map<String, Object> params = new HashMap<String, Object>();
params.put("amount", 10000); // amount to charge in cents
params.put("currency", "usd");
params.put("source", "tok_visa");

// Decide how what to send to the connected account
Map<String, Object> destinationParams = new HashMap<String, Object>();
destinationParams.put("account", "acct_XXXXX"); // connected account id
destinationParams.put("amount", 9000); // amount to send to the connected account
params.put("destination", destinationParams);
Charge charge = Charge.create(params);