data class EmailInfo(
        val emailto: String,
        val emailfrom: String,
        val emailcc: String,
        val emailbcc: String,
        val emailsubject: String,
        val emailtag: String,
        val emailtextbody: String,
        val attachments: List<Attachment>
)

data class EmailRequest(
        val email: EmailInfo
)

...

val emailRequest = EmailRequest(
        email = EmailInfo(
                emailto = "...",
                emailfrom = "...",
                emailcc = "...",
                emailbcc = "...",
                emailsubject = "...",
                emailtag = "...",
                emailtextbody = "...",
                attachments = ...
        )
)

val json = Gson().toJson(emailRequest)

val body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json)
val request = Request.Builder()
        .url(url)
        .post(body)
        .build()
}