DescribeParametersRequest request = new DescribeParametersRequest();
DescribeParametersResult response;
do
{
    response = client.describeParameters(request);
    for (ParameterMetadata param : response.getParameters())
    {
        // do something with metadata
    }
    request.setNextToken(response.getNextToken());
}
while ((response.getNextToken() != null) && ! respose.getNextToken.isEmpty());