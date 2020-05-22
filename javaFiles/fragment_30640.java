protocol Resource {}
class Movie : Resource {}
class Song : Resource {}

class APIRequest<T:Resource> { /* ... */ }

func executeRequest<T:Resource> (request: APIRequest<T>) { /* ... */ }