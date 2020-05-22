interface Actor : Type {
    val posts: Config<String, out BasePostsArgs>
}

interface SomeConflict : Type {
    val posts: Config<String, out BasePostsArgs>
}

object Organization : Type, SomeConflict, Actor {
    override val posts: Config<String, Organization.PostsArgs> = configStub(PostsArgs())

    /* ... */
}