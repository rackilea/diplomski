AmazonApiGateway apiGateway = ...;
UpdateStageRequest req = new UpdateStageRequest().withRestApiId(<api-id>).
            withStageName(<stage-name>).
            withPatchOperations(
                new PatchOperation().withPath("*/*/metrics/enabled")
                                    .withOp("replace")
                                    .withValue("true"));

apiGateway.upate(req);