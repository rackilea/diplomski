try {


            InvokeRequest invokeRequest = new InvokeRequest();
            invokeRequest.setFunctionName(FunctionName);
            invokeRequest.setPayload(ipInput);


            returnDetails = byteBufferToString(
                    lambdaClient.invoke(invokeRequest).getPayload(),
                    Charset.forName("UTF-8"),logger);
        } catch (Exception e) {

            logger.log(e.getMessage());
        }