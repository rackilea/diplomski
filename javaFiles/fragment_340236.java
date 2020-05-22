class AggContainer {
    final String b1;
    final List<Response3> response3s;

    AggContainer(String b1, List<Response3> response3s) {
        this.b1 = b1;
        this.response3s = response3s;
    }
}

class AggResponse {
    final String a1;
    final String a2;
    final String d1;
    final List<AggContainer> response2s;

    AggResponse(String a1, String a2, String d1, List<AggContainer> response2s) {
        this.a1 = a1;
        this.a2 = a2;
        this.d1 = d1;
        this.response2s = response2s;
    }

    AggResponse(String d1) {
        this.a1 = null;
        this.a2 = null;
        this.d1 = d1;
        this.response2s = null;
    }

    AggResponse(List<AggContainer> response2s) {
        this.a1 = null;
        this.a2 = null;
        this.d1 = null;
        this.response2s = response2s;
    }
}

private Mono<AggResponse> service23Agg(String a1) {
    return service2(a1).flatMap(response2 -> service3(response2.b1).collectList()
            .map(response3s -> new AggContainer(response2.b1, response3s)))
            .collectList()
            .map(AggResponse::new);
}

private Mono<AggResponse> service4Agg(String a2) {
    return service4(a2).map(response4 -> new AggResponse(response4.d1));
}