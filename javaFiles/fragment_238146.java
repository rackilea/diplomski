@Cached(
    key = "my.cached.page",
    expires = 30,
    region = "pages"
)
public Result index() {
    ...
}