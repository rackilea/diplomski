buildscript {
    repositories.jcenter()
    dependencies.add("classpath", "com.squareup.okio:okio:1.0.0")
    dependencies.add("classpath", "com.squareup.okhttp3:okhttp:3.10.0")
}

URL url = new okhttp3.HttpUrl.Builder()
    .scheme("http")
    .host("localhost")
    .port(3333)
    .addPathSegments("address")
    .build().url()