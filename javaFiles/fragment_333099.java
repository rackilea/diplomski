@Override
public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
   return Mono.from(body).flatMap { buffer -> 
      val size = readUtf8Line(buffer)
      // recompute 'Content-Length', if applicable

      super.writeWith(Mono.just(buffer))
   }
}