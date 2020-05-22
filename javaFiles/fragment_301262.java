include "console.iol"

execution { concurrent }

type TwiceRequest: void {
    .number: int
}

type TwiceResponse: void {
    .result: int
}

interface LocalInterface {
    RequestResponse:
        twice(TwiceRequest)(TwiceResponse)
}

inputPort TwiceIP {
    Location: "local"
    Interfaces: LocalInterface
}

main {
    [twice( request )( response ) {
        println@Console("Hello World")();
        response.result = request.number * 2
    }]
}