val abc = data?.get("abc")

val action = when {
    abc == null -> SomeActivity::class.java
    abc.contains("details") -> OtherActivity::class.java
    // other branches
    else -> SomeActivity::class.java
}
val intent = Intent(this, action)