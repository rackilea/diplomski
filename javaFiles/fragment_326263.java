import io.swagger.annotations.ApiParam;
[...]


@POST
@Timed
public Prediction predict(
        @QueryParam("content") @NotEmpty @ApiParam(required = true) String content,
        @HeaderParam("outputProbability") @DefaultValue("false") Boolean outputProbability) {