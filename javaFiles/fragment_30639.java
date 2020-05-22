class APIRequest<T> {}
class Movie {}
class MovieRequest : APIRequest<Movie> {}
let m = MovieRequest()
//print(m)

func executeRequest<T> (request: APIRequest<T>) {
    print(request)
}

executeRequest(m)