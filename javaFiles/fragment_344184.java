val json = """
"email":{
    "emailto":"${emailto}",
    "emailfrom":"${emailfrom}",
    "emailcc":"${emailcc}",
    "emailbcc":"${emailbcc}",
    "emailsubject":"${emailsubject}",
    "emailtag":"${emailtag}",
    "emailtextbody":"${emailtextbody}",
    "attachments":[]
}
""".trimIndent()

val body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json)
val request = Request.Builder()
        .url(url)
        .post(body)
        .build()