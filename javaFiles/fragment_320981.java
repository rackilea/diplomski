public class TestStellar2 {


      public static void main(String args[]) {

        Server server = new Server("https://horizon-testnet.stellar.org");
        KeyPair account = KeyPair.fromAccountId("GC2BKLYOOYPDEFJKLKY6FNNRQMGFLVHJKQRGNSSRRGSMPGF32LHCQVGF");

        PaymentsRequestBuilder paymentsRequest = server.payments().forAccount(account);


        paymentsRequest.stream(new EventListener <OperationResponse>(){
          @Override
          public void onEvent(OperationResponse payment) {

            if (payment instanceof PaymentOperationResponse) {
              if (((PaymentOperationResponse) payment).getTo().equals(account)) {
                return;
              }

              String amount = ((PaymentOperationResponse) payment).getAmount();

              Asset asset = ((PaymentOperationResponse) payment).getAsset();
              String assetName;
              if (asset.equals(new AssetTypeNative())) {
                assetName = "lumens";
              } else {
                StringBuilder assetNameBuilder = new StringBuilder();
                assetNameBuilder.append(((AssetTypeCreditAlphaNum) asset).getCode());
                assetNameBuilder.append(":");
                assetNameBuilder.append(((AssetTypeCreditAlphaNum) asset).getIssuer().getAccountId());
                assetName = assetNameBuilder.toString();
              }

              StringBuilder output = new StringBuilder();
              output.append(amount);
              output.append(" ");
              output.append(assetName);
              output.append(" from ");
              output.append(((PaymentOperationResponse) payment).getFrom().getAccountId());
              System.out.println(output.toString());
            }
          }
        }); 

        /**
         * option 1
         * 
         */
       /*try {
            System.in.read();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/

        /**
         * option 2
         */
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

      }

    }