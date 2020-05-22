@(message: String, contactForm: Form[Contact])

@import helper._

@main("Contact") {
<link rel="stylesheet" media="screen" href="@routes.Assets.at("stylesheets/contact.css")">
<div id="pageContainer">
    <div id="form">
        <div id="topText">
            <p>Have a question or need some assistance? Let us know and we'll get back to you ASAP.</p>
        </div>
        <br/>
        @form(routes.Home.contact()) {
            <div id="contactInfo">
                <label class="contactLabel">First Name:</label> @inputText(contactForm("firstName"), 'class -> "contactInput"') <br />
                <label class="contactLabel">Last Name:</label> @inputText(contactForm("lastName"), 'class -> "contactInput"') <br />
                <label class="contactLabel">Email:</label> @inputText(contactForm("email"), 'class -> "contactInput"') <br />
                <label class="contactLabel">Company:</label> @inputText(contactForm("company"), 'class -> "contactInput"') <br />
                <input type="hidden" id="hidden" name="hidden"></input>
                <p id="crap">@message</p>
            </div>
            <br/>
            <div id="message">
                <label class="contactLabel">Message:</label><textarea cols="50" rows="10"></textarea>
            </div>
            <input type="submit" value="Submit" />
        }
    </div>
</div>
}