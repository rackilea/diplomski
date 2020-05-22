boolean errorStatus = statusCode >= 400;
if (errorStatus) {
    emitter.onError(new HttpClientResponseException(response.getStatus().getReason(), response));
} else {
    emitter.onNext(response);
    emitter.onComplete();
}